<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head><title>提交任意2个整数给servlet的页面</title></head>
<body>
<h3>按照下列格式要求，输入两个整数数据：</h3><br>
<form action="/oa/homework" method="get">
    数据 1：<input name="num1"><br><br>
    数据 2：<input name="num2"><br><br>
    <input type=submit value="提交">
</form>
</body>
</html>