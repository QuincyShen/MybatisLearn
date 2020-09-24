package com.quincy.mapper;

import com.quincy.pojo.Teacher;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ITeacherMapperTest {
    @Test
    public void getTeacher(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ITeacherMapper mapper = sqlSession.getMapper(ITeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
