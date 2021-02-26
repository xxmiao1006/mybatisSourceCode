package com.xuemiao.mybatis_myself.mapper;

import com.xuemiao.mybatis_myself.pojo.User;

import java.util.List;

/**
 * @author xxm
 * @date 2021/2/26 10:01
 */
public interface UserMapper {

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();
}
