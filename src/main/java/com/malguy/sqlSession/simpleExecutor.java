package com.malguy.sqlSession;

import com.malguy.config.BoundSql;
import com.malguy.pojo.Configuration;
import com.malguy.pojo.MappedStatement;
import com.malguy.utils.GenericTokenParser;
import com.malguy.utils.ParameterMapping;
import com.malguy.utils.ParameterMappingTokenHandler;
import com.malguy.utils.TokenHandler;
import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class simpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration config, MappedStatement ms, Object... params) {
        //1,注册驱动,获取连接
        try {
//            System.out.println(Arrays.toString(params));//yes
            Connection conn = config.getDataSource().getConnection();
            //2,获取sql语句
            String sql = ms.getSql();
//            System.out.println(sql);//yes
            //给sql填充参数
            BoundSql boundSql = getBoundSql(sql);
//            System.out.println(boundSql);
            //3,获取预处理对象
            PreparedStatement preparedStatement = conn.prepareStatement(boundSql.getSqlText());
            //4,设置参数 (根据得到的参数名称来反射获取传过来的类里的属性
            String parameterType = ms.getParameterType();//获取参数全路径
            Class<?> parameterTypeClass = getClassType(parameterType);
            List<ParameterMapping> parameterMappingList =
                    boundSql.getParameterMappingList();
//            System.out.println(boundSql);
            for (int i = 0; i < parameterMappingList.size(); i++) {
                //获取参数名
                ParameterMapping parameterMapping = parameterMappingList.get(i);
                String content = parameterMapping.getContent();//参数名
                //反射
                Field declaredField = parameterTypeClass.getDeclaredField(content);
                declaredField.setAccessible(true);//设置(暴力)可访问
                //得到对应参数的值
                Object o = declaredField.get(params[0]); //params[0] == 传过来的user
                preparedStatement.setObject(i + 1, o);
            }
            //5,执行操作
            ResultSet resultSet = preparedStatement.executeQuery();
            String resultType=ms.getResultType();
            Class<?> resultTypeClass = getClassType(resultType);
            Object instance = null;
            //6,封装返回结果集
            ArrayList<Object> objects = new ArrayList<>();
            while(resultSet.next()){
                //封装的对象
                instance=resultTypeClass.newInstance();
                //元数据
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //获取字段名
                    String columnName = metaData.getColumnName(i);
                    //获取字段值
                    Object value = resultSet.getObject(columnName);
                    //反射,根据数据库表和实体类的映射关系来封装类
                    PropertyDescriptor propertyDescriptor = //会根据参数一的参数名生成getset方法
                            new PropertyDescriptor(columnName,resultTypeClass);
                    Method writeMethod = propertyDescriptor.getWriteMethod();//写方法
                    writeMethod.invoke(instance,value);
                }
                //放入集合
                objects.add(instance);
            }
            return (List<E>)objects;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //删除,修改
    @Override
    public int queryOther(Configuration config, MappedStatement ms, Object... params) {
        //1,注册驱动,获取连接
        try {
//            System.out.println(Arrays.toString(params));//yes
            Connection conn = config.getDataSource().getConnection();
            //2,获取sql语句
            String sql = ms.getSql();
//            System.out.println(sql);//yes
            //给sql填充参数
            BoundSql boundSql = getBoundSql(sql);
//            System.out.println(boundSql);
            //3,获取预处理对象
            PreparedStatement preparedStatement = conn.prepareStatement(boundSql.getSqlText());
            //4,设置参数 (根据得到的参数名称来反射获取传过来的类里的属性
            String parameterType = ms.getParameterType();//获取参数全路径
            Class<?> parameterTypeClass = getClassType(parameterType);
            List<ParameterMapping> parameterMappingList =
                    boundSql.getParameterMappingList();
//            System.out.println(boundSql);
            for (int i = 0; i < parameterMappingList.size(); i++) {
                //获取参数名
                ParameterMapping parameterMapping = parameterMappingList.get(i);
                String content = parameterMapping.getContent();//参数名
                //反射
                Field declaredField = parameterTypeClass.getDeclaredField(content);
                declaredField.setAccessible(true);//设置(暴力)可访问
                //得到对应参数的值
                Object o = declaredField.get(params[0]); //params[0] == 传过来的user
                preparedStatement.setObject(i + 1, o);
            }
            //5,执行操作
            boolean flag = preparedStatement.execute();
            if (flag) return 1; //成功
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    private Class<?> getClassType(String parameterType) throws Exception {
        if (parameterType != null) {
            Class<?> aClass = Class.forName(parameterType);
            return aClass;
        }
        return null;
    }

    /**
     * 1,#{}转换为? 2,#{}里的值存储起来
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类: 配合标记解析器完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler =
                new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser =
                new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出来的sql
        String parseSql = genericTokenParser.parse(sql);
        //System.out.println(parseSql);//?
        //#{}里解析出来的参数名称
        List<ParameterMapping> parameterMappings =
                parameterMappingTokenHandler.getParameterMappings();
        //System.out.println(parameterMappings);//?
        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
