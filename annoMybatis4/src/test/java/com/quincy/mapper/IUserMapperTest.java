package com.quincy.mapper;

import com.quincy.pojo.User;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class IUserMapperTest {
    @Test
    public void getUserList(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        底层主要使用到反射
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        底层主要使用到反射
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        底层主要使用到反射
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(7,"Alice","123");
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        底层主要使用到反射
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(7,"Alice","123789");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        底层主要使用到反射
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(7,"Alice","123789");
        mapper.deleteUser(7);
        sqlSession.commit();
        sqlSession.close();
    }
}
