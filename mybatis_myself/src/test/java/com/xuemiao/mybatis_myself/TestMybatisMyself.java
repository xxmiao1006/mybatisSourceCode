package com.xuemiao.mybatis_myself;

import com.xuemiao.mybatis_myself.mapper.UserMapper;
import com.xuemiao.mybatis_myself.pojo.User;
import com.xuemiao.mybatis_myself.session.SqlSession;
import com.xuemiao.mybatis_myself.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author xxm
 * @date 2021/2/26 10:09
 */
public class TestMybatisMyself {
    @Test
    public void testMybatis() {
        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
