<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账号</title>
</head>
<body>
<h1>Register Page</h1>
<hr>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名:<input type="text" name="username" align="50%"><br>
    密码:<input type="password" name="password" align="50%"><br>
    确认密码:<input type="password" name="password2" align="50%"><br>
    <input type="submit" value="注册" />
</form>

</body>
</html>
