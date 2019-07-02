<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/30 0030
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加员工</title>
</head>
<body>
    <form method="post" action="/admin/manageEmployee/addEmployee.do">
        <table align="center">
            <tr><td>ID：</td><td><input type="text"  name="id"/></td></tr>
            <tr><td>姓名：</td><td><input type="text" name="name"/></td></tr>
            <tr><td>身份证号：</td><td><input type="text" name="idNumber"/></td></tr>
            <tr><td>电话号码：</td><td><input type="text" name="phoneNumber"/></td></tr>
            <tr><td>性别：</td><td><input type="text" name="gender"/></td></tr>
            <tr><td>部门编号：</td><td><input type="text" name="deptId"/></td></tr>
            <tr><td>职位编号：</td><td><input type="text" name="positionId"/></td></tr>
            <tr><td>密码：</td><td><input type="text" name="password"/></td></tr>
            <tr><td><button type="submit" value="提交">提交</button></td></tr>
        </table>

    </form>

</body>
</html>
