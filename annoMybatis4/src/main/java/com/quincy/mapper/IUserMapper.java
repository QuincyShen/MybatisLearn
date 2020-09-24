package com.quincy.mapper;

import com.quincy.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {
    //查询全部用户
    @Select("select * from user")
    List<User> getUserList();

    //通过ID查询,方法有多个参数,所有的参数前面必须加上@Param注解
    @Select("select * from user where id = #{id1}")
    User getUserById(@Param("id1") int id);

    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{pwd})")
    void addUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(@Param("id") int id);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    void updateUser(User user);
}
