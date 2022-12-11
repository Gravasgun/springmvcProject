<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增部门</title>
</head>
<body>
<h1>新增部门</h1>
<hr>
<form action="${pageContext.request.contextPath}/dept/insert" method="post">
    部门编号<input type="text" name="deptno"/><br>
    部门名称<input type="text" name="dname"/><br>
    部门位置<input type="text" name="location"/><br>
    <input type="submit" value="保存"/><br>
</form>
</body>
</html>