package com.quincy.mapper;

import com.quincy.pojo.User;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IUserMapperTest {
    @Test
    public void getUserList(){
        //1、获取SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        //2、方式一,getMapper,执行SQL
//        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
//        List<User> userList = mapper.getUserList();

        //2、方式2,不推荐使用
        List<User> userList = sqlSession.selectList("com.quincy.mapper.IUserMapper.getUserList");

        for (User user:userList) {
            System.out.println(user);
        }

        //3、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByID(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = mapper.getUserByID(2);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(4,"Tom","123");
        mapper.addUser(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(4,"Tom","123456789");
        mapper.updateUser(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserMap(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName","Tom");
        map.put("password","123456789");
        map.put("userId",4);
        mapper.addUserMap(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserByMap(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","Tom");
        map.put("userId",4);
        User user = mapper.getUserByMap(map);
        System.out.println(user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("value","%Tom%");
        List<User> userList = mapper.getUserLike(map);
        for (User user:userList) {
            System.out.println(user);
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
