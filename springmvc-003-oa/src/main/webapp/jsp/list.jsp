<%--
  Created by IntelliJ IDEA.
  User: Yami
  Date: 2022/9/17
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门列表页面</title>
</head>
<body>
<h1 align="center">部门列表</h1>
<a href="${pageContext.request.contextPath}/user/exit">[退出系统]</a>
<hr>
<table border="1px" align="center" width="50%">
    <tr>
        <th>序号</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${deptList}" varStatus="deptStatus" var="dept">
        <tr>
            <td align="center">${deptStatus.count}</td>
            <td align="center">${dept.deptno}</td>
            <td align="center">${dept.dname}</td>
            <td>
                <a href="${pageContext.request.contextPath}/dept/delete?deptno=${dept.deptno}">删除</a>
                <a href="${pageContext.request.contextPath}/dept/selectOne?deptno=${dept.deptno}">修改</a>
                <a href="${pageContext.request.contextPath}/dept/detail?deptno=${dept.deptno}">详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href="${pageContext.request.contextPath}/jsp/add.jsp">新增部门</a>
</body>
</html>