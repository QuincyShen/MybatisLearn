//package com.quincy.mapper;
//
//import com.quincy.pojo.Student;
//import com.quincy.utils.MyBatisUtil;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.List;
//
//public class IStudentMapperTest {
//    @Test
//    public void getStudents(){
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
//        List<Student> studentList = mapper.getStudents();
//        for (Student student:studentList) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
//}
