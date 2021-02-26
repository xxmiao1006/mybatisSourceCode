package com.xuemiao.mybatis_myself.binding;

import com.xuemiao.mybatis_myself.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @author xxm
 * @date 2021/2/26 9:40
 */
public class MapperProxyFactory<T> {

    public static <T> T getMapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        //创建一个invocationhandler的动态代理对象
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[] {mapperInterface}, mapperProxy);
    }
}
