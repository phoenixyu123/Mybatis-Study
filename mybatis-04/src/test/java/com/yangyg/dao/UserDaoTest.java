package com.yangyg.dao;

import com.yangyg.pojo.User;
import com.yangyg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:45
 */


public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testLog4j(){
        logger.info("info:进入了 testLog4j");
        logger.debug("debug:test");
        logger.error("error:test");
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

}
