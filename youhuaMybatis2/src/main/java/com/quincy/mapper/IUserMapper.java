package com.quincy.mapper;

import com.quincy.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserByID(int id);

    //插入用户
    void addUser(User user);

    //修改用户
    void updateUser(User user);

    //删除用户
    void deleteUser(int id);
}
