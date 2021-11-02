package com.yangyg.dao;

import com.yangyg.pojo.User;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:09
 */
public interface UserMapper {

    /**
     * 根据id获取User用户信息
     * @param id 用户id
     * @return 返回User对象
     */
    User getUserById(Integer id);


}
