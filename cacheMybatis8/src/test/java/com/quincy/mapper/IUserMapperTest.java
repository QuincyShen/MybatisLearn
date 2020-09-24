package com.quincy.mapper;

import com.quincy.pojo.User;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class IUserMapperTest {
    @Test
    public void getUserById(){
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
        IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
        User user1 = mapper1.getUserById(1);
        System.out.println(user1);
        sqlSession1.close();

        System.out.println("==================================");

        IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        sqlSession2.close();
    }
}
