package com.xuemiao.mybatis_myself.executor.resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 10:28
 */
public interface ResultSetHandler {
    <E> List<E> handleResultSets(ResultSet resultSet) throws Exception;
}
