package com.malguy.sqlSession;

import com.malguy.pojo.Configuration;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
