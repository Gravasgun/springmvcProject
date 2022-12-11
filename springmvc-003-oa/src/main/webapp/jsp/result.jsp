<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>加法运算</title>
</head>
<body>

<form action="" name="login" method="post">
  <input type="text" name="one" value="${num1}">+<input type="text" name="two" value="${num2}">
  =<input type="text" name="result" value="${result}" ><br>
  <input type="submit" value="结果">
  <input type="submit" value="取消">
</form>
</body>
</html>
