package com.quincy.mapper;

import com.quincy.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    User getUserById(@Param("id") int id);
}
