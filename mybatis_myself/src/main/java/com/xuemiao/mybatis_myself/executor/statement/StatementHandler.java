package com.xuemiao.mybatis_myself.executor.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author xxm
 * @date 2021/2/26 10:34
 */
public interface StatementHandler {
    PreparedStatement prepare(Connection connection);

    ResultSet query(PreparedStatement statement);
}
