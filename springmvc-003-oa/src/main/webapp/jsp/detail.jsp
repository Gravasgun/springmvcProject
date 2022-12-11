<%--
  Created by IntelliJ IDEA.
  User: Yami
  Date: 2022/9/17
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>部门详情</title>
</head>
<body>
<h1>部门详情</h1>
<hr>
部门编号:${dept.deptno}<br>
部门名称:${dept.dname}<br>
部门位置:${dept.location}<br>

<input type="button" value="后退" onclick="window.history.back()"/>
</body>
</html>