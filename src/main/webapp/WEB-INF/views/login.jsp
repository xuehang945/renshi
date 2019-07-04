<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
<form action="${pageContext.request.contextPath}/login/login.do" method="post">
    用户名：<input type="text" name="id">
    <br>
    密码：<input type="password" name="password">
    <br>
    角色：<select name="role">
    <option value="employee">员工</option>
    <option value="manager">经理</option>
    <option value="admin">管理员</option>
</select>
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
