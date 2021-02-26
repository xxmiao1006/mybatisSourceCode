package com.xuemiao.mybatis_myself.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xxm
 * @date 2021/2/26 10:32
 */
public interface ParameterHandler {
    void setParameters(PreparedStatement ps) throws Exception;
}
