package com.malguy.config;

import com.malguy.utils.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class BoundSql {
    private String sqlText;//解析后的sql

    public String getSqlText() {
        return sqlText;
    }

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }

    private List<ParameterMapping> parameterMappingList=
            new ArrayList<ParameterMapping>();
}
