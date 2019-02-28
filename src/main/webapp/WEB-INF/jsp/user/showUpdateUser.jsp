<%--
  Created by IntelliJ IDEA.
  User: pyh
  Date: 2018/10/10
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改用户</title>
    <link rel="stylesheet" href="/hrmapp/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/hrmapp/frame/static/css/style.css">
    <link rel="icon" href="/hrmapp/frame/static/image/code.png">
</head>
<body class="body">
<div class="my-form">
    <header class="layui-elip">修改用户</header>
    <form class="layui-form " action="updateUser?flag=2" method="post" >
        <input type="hidden" name="id" value="${user.id }">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" value="${user.username }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="text" name="status" required  lay-verify="required" placeholder="请输入状态" value="${user.status }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登录名</label>
            <div class="layui-input-block">
                <input type="text" name="loginname" required  lay-verify="required" placeholder="请输入登录名" value="${user.loginname }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" value="${user.password }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit >修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="/hrmapp/frame/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['layer'], function(){
        var layer = layui.layer;
        if ("${requestScope.msg}" != "")
            layer.msg("${requestScope.msg}");
    });
</script>
</html>
