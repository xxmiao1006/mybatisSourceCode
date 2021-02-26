package com.xuemiao.mybatis_myself.executor.resultset;

import com.xuemiao.mybatis_myself.mapping.MappedStatement;
import com.xuemiao.mybatis_myself.reflection.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 10:29
 */
public class DefaultResultSetHandler implements ResultSetHandler {

    private MappedStatement mappedStatement;


    public DefaultResultSetHandler(MappedStatement mappedStatement) {
        super();
        this.mappedStatement = mappedStatement;
    }


    @Override
    public <E> List<E> handleResultSets(ResultSet resultSet) throws SQLException {
        if (resultSet == null) return null;
        List<E> ret = new ArrayList<E>();
        String className = mappedStatement.getResultType();
        Class<?> returnClass = null;
        //使用反射处理
        while (resultSet.next()) {
            try {
                returnClass = Class.forName(className);
                E entry = (E) returnClass.newInstance();
                Field[] declaredFields = returnClass.getDeclaredFields();
                for (Field field : declaredFields) {
                    String fieldName = field.getName();
                    if (field.getType().getSimpleName().equals("String")) {
                        ReflectionUtils.setBeanProp(entry, fieldName, resultSet.getString(fieldName));
                    } else if (field.getType().getSimpleName().equals("Integer")) {
                        ReflectionUtils.setBeanProp(entry, fieldName, resultSet.getInt(fieldName));
                    }//more type
                    ret.add(entry);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    public MappedStatement getMappedStatement() {
        return mappedStatement;
    }


    public void setMappedStatement(MappedStatement mappedStatement) {
        this.mappedStatement = mappedStatement;
    }


}
