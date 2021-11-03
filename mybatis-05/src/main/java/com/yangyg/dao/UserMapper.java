package com.yangyg.dao;

import com.yangyg.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:09
 */
public interface UserMapper {


    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    Integer addUser(User user);

    @Update("update user set name = #{name},pwd = #{password} where id=#{id}")
    Integer updateUser(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(@Param("id") Integer id);
}
