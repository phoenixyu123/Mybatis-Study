package com.yangyg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Yang YiGang
 * @version 1.0
 * @date 2021/10/31 21:07
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
