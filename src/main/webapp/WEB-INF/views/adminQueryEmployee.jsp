<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/30 0030
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索员工</title>
</head>
<body>
<h3 align="center">请输入搜索条件</h3>
<div class="row clearfix">
    <div class="col-md-12 column">
        <form method="post" action="adminQueryEmployee.do">
        <table class="table table-hover table-striped">
            <tr>
                <tr><td>ID:</td><td><input type="text" name="id"></td></tr>
                <tr><td>姓名：</td><td><input type="text" name="name"></td></tr>
                <tr><td>身份证号码：</td><td><input type="text" name="idNumber"></td></tr>
                <tr><td>手机号：</td><td><input type="text" name="phoneNumber"></td></tr>
                <tr><td>部门编号:</td><td><input type="text" name="deptId"></td></tr>
                <tr><td>职位编号:</td><td><input type="text" name="positionId"></td></tr>
        </table>
        </form>
    </div>
</div>
</body>
</html>
