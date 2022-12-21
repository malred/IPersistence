package com.malguy.config;

import com.malguy.pojo.Configuration;
import com.malguy.pojo.MappedStatement;
import com.sun.org.apache.xml.internal.utils.NameSpace;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class XMLMapperBuilder {
    private Configuration configuration;
    public XMLMapperBuilder(Configuration configuration){
        this.configuration = configuration;
    }

    /**
     * 解析mapper.xml
     * @param inputStream mapper.xml的字节输入流
     */
    public void parse(InputStream inputStream) throws Exception{
        Document dom = new SAXReader().read(inputStream);
        Element root = dom.getRootElement();//mapper标签
        String namespace = root.attributeValue("namespace");
        List<Element> selectNodes = root.selectNodes("//select");
        List<Element> updateNodes = root.selectNodes("//update");
        List<Element> deleteNodes = root.selectNodes("//delete");
        List<Element> insertNodes = root.selectNodes("//insert");
        fill(selectNodes,namespace,true);
        fill(updateNodes,namespace,false);
        fill(deleteNodes,namespace,false);
        fill(insertNodes,namespace,false);
    }
    public void fill(List<Element> nodes,String namespace,boolean haveRes){
        for (Element node : nodes) {
            String id = node.attributeValue("id");
            String resultType = node.attributeValue("resultType");
            String parameterType = node.attributeValue("parameterType");
            String sqlText = node.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            if(haveRes) mappedStatement.setResultType(resultType);
            else mappedStatement.setResultType(null);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setSql(sqlText);
            //存入配置类,key应为mapper对应方法的全类名
            String key= namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
//            System.out.println(configuration.toString());//有获得属性
        }
    }
}
