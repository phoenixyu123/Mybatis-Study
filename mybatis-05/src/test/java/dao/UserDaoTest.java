package dao;

import com.yangyg.pojo.User;
import com.yangyg.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

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

    @Test
    public void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);//起始下标 data[1]
        map.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds方法
        RowBounds rowBounds = new RowBounds(1, 3);

        //通过Java 代码层实现分页
        List<User> users = sqlSession.selectList("com.yangyg.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : users) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

}
