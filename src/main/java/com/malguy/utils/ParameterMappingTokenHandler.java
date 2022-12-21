package com.malguy.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class ParameterMappingTokenHandler implements TokenHandler{
    private List<ParameterMapping> parameterMappings=new ArrayList();
    //context就是参数名称 #{id} -> id
    @Override
    public String handlerToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }
    private ParameterMapping buildParameterMapping(String content){
        ParameterMapping parameterMapping = new ParameterMapping(content);
        return parameterMapping;
    }
    public List<ParameterMapping> getParameterMappings(){
        return parameterMappings;
    }
    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}
