package com.malguy.sqlSession;

import com.malguy.config.XMLConfigBuilder;
import com.malguy.pojo.Configuration;

import java.io.InputStream;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) throws Exception {
        //1,dom4j解析xml,封装到configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);
//        System.out.println(configuration);//有数据
        //2,创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory =
                new DefaultSqlSessionFactory(configuration);
        sqlSessionFactory.openSession();
        return sqlSessionFactory;
    }
}
