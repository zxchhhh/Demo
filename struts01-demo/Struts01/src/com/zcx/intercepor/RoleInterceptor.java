package com.zcx.intercepor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zcx.entity.User;

import java.util.Map;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/12 17:04
 */
// 权限拦截器
public class RoleInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        // 获取session存取的对象 ,获取action上下文对象
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        User user=(User)session.get("user");
        if(user.getRole() == 2){
            // 进入管理员界面
            return Action.INPUT;
        }
        return invocation.invoke();
    }




}
