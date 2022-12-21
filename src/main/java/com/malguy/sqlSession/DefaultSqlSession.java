package com.malguy.sqlSession;

import com.malguy.pojo.Configuration;
import com.malguy.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementid, Object... params) {
        //对simpleExecutor里的方法的调用
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
//        System.out.println(mappedStatement);//yes
//        System.out.println(statementid);//yes
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementid, Object... params) {
        List<Object> objects = selectList(statementid, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或返回结果过多");
        }
    }

    @Override
    public int deleteOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public int updateOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public int insertOne(String statementid, Object... params) {
        simpleExecutor simpleExecutor = new simpleExecutor();
        MappedStatement mappedStatement =
                configuration.getMappedStatementMap().get(statementid);
        return simpleExecutor.queryOther(configuration, mappedStatement, params);
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理为DAO接口生成代理对象,并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),
                new Class[]{mapperClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //底层都是调jdbc,根据不同情况,调用不同方法
                        //准备参数,statementid(sql语句唯一标识) = namespace.id=dao接口全类名.方法名
                        //方法名获取 findAll
                        String methodName = method.getName();
                        //获取该方法所在的字节码对象,然后获取全类名
                        String className = method.getDeclaringClass().getName();
                        //拼接
                        String statementId = className +"."+ methodName;
                        //准备参数,params
                        //获取被调用方法的返回值类型(如List<xxx>,和User类)
                        Type genericReturnType = method.getGenericReturnType();
                        //todo 判断是什么类型标签
                        //判断是否进行了 泛型类型参数化(即是否使用泛型(比如List))
                        if (genericReturnType instanceof ParameterizedType) {
                            List<Object> objects = selectList(statementId, args);
                            return objects;
                        }
                        return selectOne(statementId, args);
                    }
                });
        return (T) proxyInstance;
    }
}
