<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27 0027
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>

    <form action="login/check.do" method="post">
        <table>
            <tr><td>ID：</td><td><input type="text" name="id"/></td></tr>
            <tr><td>密码：  </td><td><input type="text" name="password"/></td></tr>
            <tr><td>类别：  </td><td><input type="radio" name="role" value="员工">员工
                <input type="radio" name="role" value="经理">经理</td></tr>
                <input type="radio" name="role" value="管理员">管理员</td></tr>

        </table>
        <button type="submit" value="登录">登录</button>
    </form>

    <a href="adminLogin.jsp">管理员登录</a>
</head>
<body>

</body>
</html>
