<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/11
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<script type="text/javascript" src="/js/jquery-1.7.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            var data=$("#myform").serialize();
            alert(data)
            $.post("add",data,function (re) {
                alert("进来了")
                if(re.retcode==1){
                    alert(re.retmsg);
                    window.location.href="index";
                }else {
                    alert(re.retmsg);
                }
            },"json")
        })
    })
</script>
<form id="myform" method="post" action="#">
    <table align="center" >
        <tr>
            <td>请输入用户名：</td>
            <td><input type="text" name="user.name" id="name"></td>
        </tr>
        <tr>
            <td>请输入密码：</td>
            <td><input type="password" name="user.password" id="password"></td>
        </tr>
        <tr>
            <td>请选择角色：</td>
            <td>
            <select name="user.role" id="role">
                <option value="1">管理员</option>
                <option value="2">普通用户</option>
            </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="button" id="btn" value="提交"></td>
        </tr>
    </table>
</form>


</body>
</html>
