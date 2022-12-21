package com.malguy.pojo;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class Configuration {
    private DataSource dataSource;

    //key: 唯一标识id value: MappedStatement对象
    private Map<String,MappedStatement> mappedStatementMap=new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "dataSource=" + dataSource.toString() +
                ", mappedStatementMap=" + mappedStatementMap.toString() +
                '}';
    }
}
