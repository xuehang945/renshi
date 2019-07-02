<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>员工信息</title>
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

                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>员工信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/employee/modify.do">修改</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">

                <tbody>

                <tr><td>ID：</td><td>${employeeVO.id}</td></tr>
                <tr><td>姓名：</td>姓名：<td>${employeeVO.name}</td></tr>
                <tr><td>身份证号码：</td><td>${employeeVO.idNumber}</td></tr>
                <tr><td>电话号码：</td><td>${employeeVO.phoneNumber}</td></tr>
                <tr><td>性别：</td><td>${employeeVO.gender}</td></tr>
                <tr><td>部门:</td><td>${employeeVO.department}</td></tr>
                <tr><td>职位:</td><td>${employeeVO.position}</td></tr>


                </tbody>
            </table>
        </div>
    </div>
</div>
