<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>更新员工信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/admin/manageEmployee/updateEmployee.do"
          method="post">
        <table>
        <tr><td>ID：</td><td><input type="text"  name="id" readonly="readonly" value="${employeeInfo.id}"/></td></tr>
        <tr><td>姓名：</td><td><input type="text" name="name" value="${employeeInfo.name}"/></td></tr>
        <tr><td>身份证号：</td><td><input type="text" name="idNumber" value="${employeeInfo.idNumber}"/></tr>
        <tr><td>电话号码：</td><td><input type="text" name="phoneNumber" value="${employeeInfo.phoneNumber}"/></td></tr>
        <tr><td>性别：</td><td><input type="text" name="gender" value="${employeeInfo.gender}"/></td></tr>
        <tr><td>部门编号：</td><td><input type="text" name="deptId" value="${employeeInfo.deptId}"/></td></tr>
        <tr><td>职位编号：</td><td><input type="text" name="positionId" value="${employeeInfo.positionId}"/></td></tr>
        <tr><td>密码：</td><td><input type="text" name="password" value="${employeeInfo.password}"/></td></tr>
        </table>
        <input type="submit" value="提交" />
    </form>
</div>
