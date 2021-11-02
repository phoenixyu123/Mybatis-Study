package com.yangyg.dao;

import com.yangyg.pojo.User;
import com.yangyg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:45
 */
public class UserDaoTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

}
