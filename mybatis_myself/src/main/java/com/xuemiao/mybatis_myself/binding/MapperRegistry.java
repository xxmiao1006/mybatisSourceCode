package com.xuemiao.mybatis_myself.binding;

import com.xuemiao.mybatis_myself.session.Configuration;

/**
 * @author xxm
 * @date 2021/2/26 11:23
 */
public class MapperRegistry {

    private Configuration config;
    /*//将已经添加的映射都放入HashMap
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    public MapperRegistry(Configuration config) {
        this.config = config;
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return MapperProxyFactory.getMapperProxy(sqlSession, type);
    }*/

}
