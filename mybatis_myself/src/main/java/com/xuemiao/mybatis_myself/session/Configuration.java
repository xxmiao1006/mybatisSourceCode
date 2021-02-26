package com.xuemiao.mybatis_myself.session;

import com.xuemiao.mybatis_myself.binding.MapperProxyFactory;
import com.xuemiao.mybatis_myself.binding.MapperRegistry;
import com.xuemiao.mybatis_myself.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxm
 * @date 2021/2/26 9:28
 */
public class Configuration {
    public static final String MAPPER_LOCATION = "mapper";

    public static final String DB_FILE = "db.properties";

    public MapperRegistry mapper_registry = new MapperRegistry(this);

    /**
     * 数据库的连接信息
     */
    private String dbUrl;

    private String dbUserName;

    private String dbPassWord;

    private String dbDriver;
    //用于存放解析的mapper中的sql操作语句
    private final Map<String, MappedStatement> mappedStatements = new HashMap<String, MappedStatement>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return MapperProxyFactory.getMapperProxy(sqlSession, type);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassWord() {
        return dbPassWord;
    }

    public void setDbPassWord(String dbPassWord) {
        this.dbPassWord = dbPassWord;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }


    public Map<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public MappedStatement getMappedStatement(String key) {
        return mappedStatements.get(key);
    }

    @Override
    public String toString() {
        return "Configuration [dbUrl=" + dbUrl + ", dbUserName=" + dbUserName + ", dbPassWord=" + dbPassWord
                + ", dbDriver=" + dbDriver + ", mappedStatements=" + mappedStatements + "]";
    }
}
