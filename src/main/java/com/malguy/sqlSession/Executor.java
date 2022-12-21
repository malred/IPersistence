package com.malguy.sqlSession;

import com.malguy.pojo.Configuration;
import com.malguy.pojo.MappedStatement;

import java.util.List;

/**
 * @author malguy-wang sir
 * @create ---
 */
public interface Executor {
    /**
     * 执行语句
     * @param config 总的配置
     * @param ms 存放sql语句
     * @param params sql语句的参数
     * @param <E> 泛型
     * @return
     */
    public <E> List<E> query(Configuration config, MappedStatement ms,Object...params);

    /**
     * 删除和修改方法
     * @param config
     * @param ms
     * @param params
     * @return
     */
    public int queryOther(Configuration config, MappedStatement ms,Object...params);
}
