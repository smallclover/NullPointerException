package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Amadeus
 * @Date: 2020/3/31 23:02
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user WHERE email=#{email}")
    User findUserById(String email);
}
