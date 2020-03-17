package com.zcx.intercepor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zcx.entity.User;

import java.util.Map;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/12 16:14
 */
// 登录拦截器
public class LoginInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {
        // 获取session存取的对象 ,获取action上下文对象
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        User user=(User)session.get("user");
        if(user == null){
            // 如果为空则返回登录界面
            return Action.LOGIN;
        }
        /*if(user != null && user.getRole() == 2){
            return Action.INPUT;
        }*/
        // 放行
        return invocation.invoke();
    }
}
