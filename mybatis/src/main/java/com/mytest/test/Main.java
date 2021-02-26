package com.mytest.test;

import com.mytest.mapper.RoleMapper;
import com.mytest.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xxm
 * @date 2021/2/3 10:14
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = null;

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(true);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            System.out.println(roleMapper.getRole(1L));
            System.out.println(roleMapper.getRole(1L));
            System.out.println(roleMapper.getRole(1L));
            //Role role = roleMapper.getRole(1L);
            //System.out.println(role.getId() + ":" + role.getRoleName() + ":" + role.getNote());
            /*Role role = sqlSession.selectOne("role", 1);
            System.out.println(role);*/

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
