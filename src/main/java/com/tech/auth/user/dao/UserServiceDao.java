package com.tech.auth.user.dao;

import com.tech.auth.user.entity.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserServiceDao {
    UserVo findUser(@Param("userId") String user);
}
