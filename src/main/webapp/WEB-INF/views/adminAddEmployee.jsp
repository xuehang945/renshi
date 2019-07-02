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
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <td>ID：</td><input type="text" name="id">
                <td>员工姓名：</td><input type="text" name="name">
                <td>手机号：</td><input type="text" name="phoneNumber">
                <td>身份证号：</td><input type="text" name="idNumber">
                <td>性别：</td><input type="text" name="gender">
                <td>部门：</td><input type="text" name="deptId">
                <td>职位：</td><input type="text" name="positionId">
                <td>密码：</td><input type="text" name="password">
            </tr>
        </table>
        <button type="submit" value="提交">提交</button>
    </form>

</body>
</html>
