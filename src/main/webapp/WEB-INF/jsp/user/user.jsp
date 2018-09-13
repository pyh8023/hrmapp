<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/hrmapp/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/hrmapp/frame/static/css/style.css">
    <link rel="icon" href="/hrmapp/frame/static/image/code.png">
</head>
<body class="body">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr align="center">
            <td><input type="checkbox" lay-skin="primary"  checked=""></td>
            <td>登录名</td>
            <td>密码</td>
            <td>用户名</td>
            <td>状态</td>
            <td>创建时间</td>
            <td align="center">操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.users}" var="user" varStatus="stat">
            <tr id="data_${stat.index}" align="center">
                <td><input type="checkbox" lay-skin="primary" value="${user.id}"></td>
                <td>${user.loginname }</td>
                <td>${user.password }</td>
                <td>${user.username }</td>
                <td>${user.status }</td>
                <td><f:formatDate value="${user.createDate}" type="date" dateStyle="long"/></td>
                <td align="center" width="40px;"><a class="layui-btn layui-btn-xs" href="/hrmapp/user/updateUser?flag=1&id=${user.id}" target="_blank">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
<script type="text/javascript" src="/hrmapp/frame/layui/layui.js"></script>
</html>