package com.xuemiao.mybatis_myself.mapping;

/**
 * @author xxm
 * @date 2021/2/26 9:29
 */
public class MappedStatement {
    private String namespace;

    private String sourceId;

    private String sql;

    private String resultType;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
