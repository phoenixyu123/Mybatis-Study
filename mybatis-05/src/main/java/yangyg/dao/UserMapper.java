package yangyg.dao;

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
     * 根据id获取User用户信息
     * @param id 用户id
     * @return 返回User对象
     */
    User getUserById(Integer id);


    /**
     * 通过sql中的limit实现分页 使用Map作为参数进行分页查询
     * @param map startIndex起始下标，pageSize页大小
     * @return 返回User List
     */
    List<User> getUserByLimit(Map<String,Integer> map);


    /**
     * 通过RowBounds实现分页
     * @return 返回User
     */
    List<User> getUserByRowBounds();

}
