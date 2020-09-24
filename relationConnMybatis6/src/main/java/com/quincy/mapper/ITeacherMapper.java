package com.quincy.mapper;

import com.quincy.pojo.Student;
import com.quincy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITeacherMapper {
    //获取所有老师
    List<Teacher> getTeachers();

    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid")int id);
}
