package com.zcx.cnotroller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import com.zcx.entity.User;
import com.zcx.service.UserService;
import com.zcx.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/12 12:14
 */
public class IndexAction extends ActionSupport {
    private User user; // 封装登录参数
    UserService userService =new UserServiceImpl();
    protected Map<String,Object> results=new HashMap<String,Object>();
    private List<User> userList;   // 接收用户信息

    // 展示全部
    public String getUsers(){
        Map session = ActionContext.getContext().getSession();
        userList = userService.getUsers();
//        session.flush();
        User user =(User) session.get("user");
//            session.put("userList",userList);
            return SUCCESS;
    }

    // 跳转增加
    public String toAdd1() throws Exception {
        return SUCCESS;
    }
    // 增加
    public String addUser() throws Exception {
        int result = userService.addUser(user);
        if(result != 0) {
            results.put("retcode", 1);
            results.put("retmsg", "添加成功");
        }else {
            results.put("retcode", 0);
            results.put("retmsg", "添加失败");
        }
        return SUCCESS;
    }


    // 跳转修改
    public String toUpdate() throws Exception {
        user = userService.getUser(user.getId());
        return SUCCESS;
    }

    // 修改
    public String updateUser(){
        int result = userService.updateUser(user);
        if(result != 0) {
            results.put("retcode", 1);
            results.put("retmsg", "修改成功");
        }
        return SUCCESS;
    }

    // 删除
    public String del() throws Exception {
        int result=userService.delUser(user.getId());
        if(result==1) return SUCCESS;
        return ERROR;
    }
    // 查找
    public String select() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(user.getId() == null){
            session.put("id","");
             userList = userService.getUsers();
//            session.put("userList",userList);
        }else {
            session.put("id",user.getId());
             userList = userService.selctUser(user.getId());
//            session.put("userList",userSelect);
        }
        return SUCCESS;
    }


    public IndexAction() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Map<String, Object> getResults() {
        return results;
    }

    public void setResults(Map<String, Object> results) {
        this.results = results;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public IndexAction(User user, UserService userService, Map<String, Object> results, List<User> userList) {
        this.user = user;
        this.userService = userService;
        this.results = results;
        this.userList = userList;
    }

}
