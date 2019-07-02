<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>管理员工</title>
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
                    <small>员工列表 —— 显示所有员工</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/manageEmployee/toAddEmployee.do">新增员工</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <form action="/admin/manageEmployee/search.do"
                  method="post">
                <div class="col-md-4 data1">
                    <input type="text" class="form-control" name="username"
                           placeholder="username" value="">
                </div>
                <button type="submit" class="btn bg-maroon">搜索</button>
            </form>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>ID：</th>
                    <th>员工姓名：</th>
                    <th>身份证号码：</th>
                    <th>手机号：</th>
                    <th>性别：</th>
                    <th>部门：</th>
                    <th>职位：</th>
                    <th>密码：</th>
                   <!-- <th>操作</th> -->
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${employeeInfos}" var="employeeInfo">
                    <tr>
                        <td>${employeeInfo.id}</td>
                        <td>${employeeInfo.name}</td>
                        <td>${employeeInfo.idNumber}</td>
                        <td>${employeeInfo.phoneNumber}</td>
                        <td>${employeeInfo.gender}</td>
                        <td>${employeeInfo.deptId}</td>
                        <td>${employeeInfo.positionId}</td>
                        <td>${employeeInfo.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/manageEmployee/toUpdateEmployee.do?id=${employeeInfo.id}">更改</a> |
                            <a href="${pageContext.request.contextPath}/admin/manageEmployee/deleteEmployee.do?id=${employeeInfo.id}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
