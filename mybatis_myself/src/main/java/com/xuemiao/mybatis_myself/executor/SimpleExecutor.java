package com.xuemiao.mybatis_myself.executor;

import com.xuemiao.mybatis_myself.executor.parameter.DefaultParameterHandler;
import com.xuemiao.mybatis_myself.executor.parameter.ParameterHandler;
import com.xuemiao.mybatis_myself.executor.resultset.DefaultResultSetHandler;
import com.xuemiao.mybatis_myself.executor.resultset.ResultSetHandler;
import com.xuemiao.mybatis_myself.executor.statement.DefaultStatementHandler;
import com.xuemiao.mybatis_myself.executor.statement.StatementHandler;
import com.xuemiao.mybatis_myself.mapping.MappedStatement;
import com.xuemiao.mybatis_myself.session.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 9:33
 */
public class SimpleExecutor implements Executor {
    private Configuration configuration;


    public SimpleExecutor(Configuration configuration) {
        super();
        this.configuration = configuration;
    }


    public <E> List<E> query(MappedStatement ms, Object parameter) throws Exception {

        //1.获取连接
        Connection connection = getConnection();
        //2.实例化statementhandler
        StatementHandler statementHandler = new DefaultStatementHandler(ms);
        //3.获取prepareStatement
        PreparedStatement prepare = statementHandler.prepare(connection);
        //4.实例化prepareHandler对象，sql语句占位符
        ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
        parameterHandler.setParameters(prepare);
        //5.查询
        ResultSet resutSet = statementHandler.query(prepare);
        //对resultSet进行处理
        ResultSetHandler resultSetHandler = new DefaultResultSetHandler(ms);
        return resultSetHandler.handleResultSets(resutSet);
    }


    /**
     * 获取数据库的连接，和jdbc一样的方式
     *
     * @return
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(configuration.getDbDriver());
            connection = DriverManager.getConnection(configuration.getDbUrl(),
                    configuration.getDbUserName(), configuration.getDbPassWord());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public Configuration getConfiguration() {
        return configuration;
    }


    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
