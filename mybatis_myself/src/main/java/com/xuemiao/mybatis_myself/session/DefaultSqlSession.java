package com.xuemiao.mybatis_myself.session;

import com.xuemiao.mybatis_myself.executor.Executor;
import com.xuemiao.mybatis_myself.executor.SimpleExecutor;
import com.xuemiao.mybatis_myself.mapping.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 9:32
 */
public class DefaultSqlSession implements SqlSession{

    private Configuration configuration;

    private Executor executor;


    public DefaultSqlSession(Configuration configuration) {
        super();
        this.configuration = configuration;
        executor = new SimpleExecutor(configuration);
    }

    public <T> T selectOne(String statement,Object parameter) {
        List<Object> selectList = this.selectList(statement, parameter);
        if (selectList == null || selectList.isEmpty()) return null;
        return (T)selectList.get(0);//返回第一个
    }

    public <E> List<E> selectList(String statement, Object parameter){
        MappedStatement ms = configuration.getMappedStatement(statement);
        try {
            return executor.query(ms, parameter);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

}
