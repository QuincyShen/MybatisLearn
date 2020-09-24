package com.quincy.mapper;

import com.quincy.pojo.Student;

import java.util.List;

public interface IStudentMapper {

    //查询所有的学生信息以及对应的老师信息
    List<Student> getStudents();
}
