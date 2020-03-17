package com.zcx.dao;

import com.zcx.entity.User;

import java.util.List;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 21:49
 */
public interface UserDao {

    // 验证登陆
    public User checkUser(User user);

    public List<User> getUsers();
    // 增
    public int addUser(User User);
    // 删
    public int delUser(Integer id);
    // 查
    public User getUser(Integer id);
    // 改
    public int updateUser(User User);
    // 查询
    public List<User> selctUser(Integer id);






}
