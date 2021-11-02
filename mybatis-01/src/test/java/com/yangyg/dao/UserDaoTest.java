package com.yangyg.dao;

import com.yangyg.pojo.User;
import com.yangyg.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:45
 */
public class UserDaoTest {
    @Test
    public void testUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userLike = mapper.getUserLike("d");
        for (User user : userLike) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testUserDao(){
        //1 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 方式一 执行Mapper.xml的SQL
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList1 = userMapper.getUserList();

        //2 方式二 执行自带的select
        List<User> list = sqlSession.selectList("com.yangyg.dao.UserMapper.getUserList");
        List<User> userList2 = userMapper.getUserList();

        for (User user1 : userList1) {
            System.out.println(user1);
        }
        for (User user2 : userList1) {
            System.out.println(user2);
        }

        //3 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        //1 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2 执行Mapper SQL——getMapper获得接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userById = userMapper.getUserById(1);
        //3 输出
        System.out.println(userById);
        //4 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",1);
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4,"add","add");
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",4);
        map.put("username","add2");
        userMapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(1,"update","update"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
