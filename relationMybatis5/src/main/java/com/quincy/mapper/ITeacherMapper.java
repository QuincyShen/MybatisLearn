package com.quincy.mapper;

import com.quincy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ITeacherMapper {
    @Select("select * from teacher where id = #{id}")
    Teacher getTeacher(@Param("id") int id);
}
