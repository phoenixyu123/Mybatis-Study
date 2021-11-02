package com.yangyg.dao;

import com.yangyg.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:09
 */
public interface UserMapper {

    /**
     * 模糊查询User集合根据name
     * @param name 名字模糊查询
     * @return 返回list集合
     */
    List<User> getUserLike(String name);

    /**
     * 接口方法必须使用javadoc注释
     * @return 返回User对象List类型
     */
    List<User> getUserList();

    /**
     * 根据id获取User用户信息
     * @param id 用户id
     * @return 返回User对象
     */
    User getUserById(Integer id);

    /**
     * 使用Map查询用户信息，假设一百个字段，只对一个字段赋值
     * @param map 表
     * @return 返回User
     */
    User getUserById2(Map<String,Object> map);

    /**
     * 添加User信息
     * @param user User类
     * @return 返回插入结果
     */
    Integer addUser(User user);

    /**
     * 使用Map添加用户信息，假设一百个字段，只对一个字段赋值
     * @param map 表
     * @return 返回int
     */
    Integer addUser2(Map<String,Object> map);

    /**
     * 修改User
     * @param user User类对象
     * @return 返回修改结果
     */
    Integer updateUser(User user);

    /**
     * 删除User
     * @param id Userid
     * @return int
     */
    Integer deleteUser(Integer id);



}
