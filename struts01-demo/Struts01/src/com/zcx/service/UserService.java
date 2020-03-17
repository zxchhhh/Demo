package com.zcx.service;

import com.zcx.entity.User;

import java.util.List;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 23:50
 */
public interface UserService {
    // 验证登陆
    public User checkUser(User user);

    public List<User> getUsers();
    // 增
    public int addUser(User user);
    // 删
    public int delUser(Integer id);
    // 查
    public User getUser(Integer id);
    // 改
    public int updateUser(User user);
    // 查询
    public List<User> selctUser(Integer id);
}
