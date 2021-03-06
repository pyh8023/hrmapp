<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <script type="text/javascript" src="/hrmapp/js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" href="/hrmapp/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/hrmapp/frame/static/css/style.css">
    <link rel="icon" href="/hrmapp/frame/static/image/code.png">
</head>
<body>

<div class="login-main">
    <header class="layui-elip">登录</header>
    <form class="layui-form" action="login" method="post">
        <div class="layui-input-inline">
            <input type="text" name="loginname" required lay-verify="required" placeholder="登录名" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
                   class="layui-input">
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" class="layui-btn">登录</button>
        </div>
        <hr/>
        <!--<div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-primary">QQ登录</button>
        </div>
        <div class="layui-input-inline">
            <button type="button" class="layui-btn layui-btn-normal">微信登录</button>
        </div>-->
        <p><a href="javascript:;" class="fl">立即注册</a><a href="javascript:;" class="fr">忘记密码？</a></p>
    </form>
</div>


<script src="/hrmapp/frame/layui/layui.js"></script>
</body>
</html>