package com.zcx.cnotroller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zcx.entity.User;
import com.zcx.service.UserService;
import com.zcx.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 21:06
 */
 // 注意导包是xwork的
public class LoginAction extends ActionSupport {
    private User user;
    private List<User> userList;
    protected Map<String,Object> results=new HashMap<String,Object>();

    UserService userService =new UserServiceImpl();


    // 登录
    public String login1() throws Exception{
        User users = userService.checkUser(user);
        if(users != null){
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("user",users);
            if(users.getRole() == 1){
                results.put("retcode", true);
                results.put("retmsg", "登录成功");
                return SUCCESS;
            }else if(users.getRole() == 2){
                results.put("retcode", true);
                results.put("retmsg", "登录成功");
                return INPUT;
            }
        }
        return ERROR;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public LoginAction() {
    }

    public LoginAction(User user, List<User> userList, UserService userService) {
        this.user = user;
        this.userList = userList;
        this.userService = userService;
    }













}
