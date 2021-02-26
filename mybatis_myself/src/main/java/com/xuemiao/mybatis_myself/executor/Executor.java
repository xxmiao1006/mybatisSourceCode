package com.xuemiao.mybatis_myself.executor;

import com.xuemiao.mybatis_myself.mapping.MappedStatement;

import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 9:32
 */
public interface Executor {
    <E> List<E> query(MappedStatement ms, Object parameter) throws Exception;
}
