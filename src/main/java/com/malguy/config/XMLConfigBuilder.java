package com.malguy.config;

import com.malguy.io.Resources;
import com.malguy.pojo.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class XMLConfigBuilder {
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration=new Configuration();
    }

    /**
     * 对配置进行解析(dom4j),封装到Configuration
     * @param in 配置文件输入流
     * @return 返回总配置类
     * @throws Exception
     */
    public Configuration parseConfig(InputStream in) throws Exception{
        Document dom = new SAXReader().read(in);
        //拿到xml的根对象 <configuration>
        Element rootElement = dom.getRootElement();
        //找到所有property
        List<Element> list = rootElement.selectNodes("//property");
        //标签的值存到配置类
        Properties properties = new Properties();
        for (Element element : list) {
            String name=element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }
        //创建数据库连接池配置类
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));
        //存入总配置类
        configuration.setDataSource(comboPooledDataSource);
        //解析mapper.xml ->路径->字节输入流->解析
        List<Element> mappers = rootElement.selectNodes("//mapper");
        for (Element mapper : mappers) {
            String mapperPath = mapper.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return configuration;
    }
}
