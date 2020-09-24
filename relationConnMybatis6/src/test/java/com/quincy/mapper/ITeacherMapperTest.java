package com.quincy.mapper;

import com.quincy.pojo.Teacher;
import com.quincy.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ITeacherMapperTest {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ITeacherMapper mapper = sqlSession.getMapper(ITeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeachers();
        for (Teacher teacher:teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacher(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ITeacherMapper mapper = sqlSession.getMapper(ITeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

}
