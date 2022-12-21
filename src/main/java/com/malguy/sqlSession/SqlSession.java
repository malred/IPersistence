package com.malguy.sqlSession;

import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface SqlSession {
    /**
     * 查询所有
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <E> 泛型
     * @return 返回查询的对象的集合
     */
    public <E> List<E> selectList(String statementid,Object...params);

    /**
     * 根据条件查询单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @param <T> 泛型
     * @return 返回一个类
     */
    public <T> T selectOne(String statementid,Object...params);

    /**
     * 根据条件删除单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int deleteOne(String statementid,Object...params);

    /**
     * 根据条件更新单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int updateOne(String statementid,Object...params);
    /**
     * 根据条件插入单个
     * @param statementid 全类名,定位方法所在
     * @param params sql语句可能的参数
     * @return 返回成功1或失败-1
     */
    public int insertOne(String statementid,Object...params);

    /**
     * 为dao接口生成代理实现类
     * @param mapperClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<?> mapperClass);
}
