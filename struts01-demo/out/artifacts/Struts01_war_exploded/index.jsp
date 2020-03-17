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
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>首页</title>
</head>
<body>
<script type="text/javascript" src="js/jquery-1.7.js"></script>
<script>

</script>
<form action="select">
<table cellspacing="0px" border="1px">
    <tr height="40px" class="b" ><td>请输入查找id：</td>
    <td colspan="2"><input type="text" value="${id}" name="user.id"></td>
        <td><input type="submit" value="查找"></td>
    </tr>
  <tr height="40px" class="b">
    <td>id</td>
    <td>用户名</td>
    <td>角色</td>
    <td colspan="3"><a href="toAdd">增加</a></td>
  </tr>
  <c:forEach items="${userList}" var="m">
    <tr>
      <td>${m.id}</td>
      <td>${m.name}</td>
      <td> <c:if test="${m.role==1}">
          管理员
      </c:if>
        <c:if test="${m.role==2}">
          普通用户
      </c:if></td>
      <td><a href="toupdate?user.id=${m.id}">修改</a></td>
      <td><a href="del?user.id=${m.id}">删除</a></td>
    </tr>
  </c:forEach>
 <%-- <s:iterator value="userList" >
    <tr>
      <td><s:property value="id" /></td>
      <td><s:property value="name" /></td>
      <td> <s:if test="#m.role == '1'">似懂非懂</s:if></td>
      <td><a href="toupdate?user.id=<s:property value="id"/>">修改</a></td>
      <td><a href="del?user.id=<s:property value="id"/>">删除</a>
      </td>
    </tr>
  </s:iterator>--%>
</table>
</form>

</body>
</html>
