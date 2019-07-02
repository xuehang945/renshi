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
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改用户</small>
                </h1>
            </div>
        </div>
    </div>

    <h3 align="center">您的ID为：${userInfo.id}</h3>

    <form action="${pageContext.request.contextPath}/admin/manageEmployee/updateEmployee.do"
          method="post">
        ID：<input type="text"  name="id" readonly="readonly" value="${employeeInfo.id}"/>
        姓名：<input type="text" name="name" value="${employee.name}"/>
        身份证号：<input type="text" name="idNumber" value="${employee.password}"/>
        电话号码：<input type="text" name="phoneNumber" value="${employee.password}"/>
        性别：<input type="text" name="gender" value="${employee.password}"/>
        部门编号：<input type="text" name="deptId" value="${employee.password}"/>
        职位编号：<input type="text" name="positionId" value="${employee.password}"/>
        密码：<input type="text" name="password" value="${employee.password}"/>
        <input type="submit" value="提交" />
    </form>
</div>
