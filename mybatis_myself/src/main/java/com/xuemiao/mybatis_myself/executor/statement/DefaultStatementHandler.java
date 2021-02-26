package com.xuemiao.mybatis_myself.executor.statement;

import com.xuemiao.mybatis_myself.mapping.MappedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xxm
 * @date 2021/2/26 10:35
 */
public class DefaultStatementHandler implements StatementHandler {

    private MappedStatement mappedStatement;


    public DefaultStatementHandler(MappedStatement mappedStatement) {
        super();
        this.mappedStatement = mappedStatement;
    }

    @Override
    public PreparedStatement prepare(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =  connection.prepareStatement(mappedStatement.getSql());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public ResultSet query(PreparedStatement statement) {
        ResultSet resultSet = null;
        try {
            resultSet =  statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
