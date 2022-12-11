<%--
  Created by IntelliJ IDEA.
  User: Yami
  Date: 2022/9/17
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改部门</title>
</head>
<body>
<h1>修改部门</h1>
<hr>

<form action="${pageContext.request.contextPath}/dept/edit" method="post">
    部门编号<input type="text" name="deptno" value="${dept.deptno}" readonly/><br>
    部门名称<input type="text" name="dname" value="${dept.dname}"/><br>
    部门位置<input type="text" name="location" value="${dept.location}"/><br>
    <input type="submit" value="修改"/><br>
</form>
</body>
</html>