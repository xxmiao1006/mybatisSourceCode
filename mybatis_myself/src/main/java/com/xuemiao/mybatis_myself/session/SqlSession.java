package com.xuemiao.mybatis_myself.session;

import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 9:31
 */
public interface SqlSession {
    <T> T selectOne(String statement,Object parameter);

    <E> List<E> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
