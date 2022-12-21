package com.malguy.pojo;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class MappedStatement {
    //id标识
    private String id;
    //返回值类型
    private String resultType;
    //参数值设置
    private String parameterType;
    //sql语句
    private String sql;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String paramterType) {
        this.parameterType = paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
