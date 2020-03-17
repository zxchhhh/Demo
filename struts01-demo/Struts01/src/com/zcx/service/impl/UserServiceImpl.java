package com.zcx.service.impl;

import com.zcx.dao.UserDao;
import com.zcx.dao.impl.UserDaoImpl;
import com.zcx.entity.User;
import com.zcx.service.UserService;

import java.util.List;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 23:50
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public int addUser(User user) {

        return userDao.addUser(user);
    }

    public int delUser(Integer id) {
        return userDao.delUser(id);
    }

    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public
    List<User> selctUser(Integer id) {
        return userDao.selctUser(id);
    }
}
