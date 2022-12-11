<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用OA系统</title>
</head>
<body>
<h1>Login Page</h1>
<hr>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username" align="50%"><br>
    密码:<input type="password" name="password" align="50%"><br>
    <input type="checkbox" name="f" value="1">十天内免登录<br>
    <input type="submit" value="登录"><br>
    <a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a>
</form>

</body>
</html>
