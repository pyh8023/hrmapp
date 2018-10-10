<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="/hrmapp/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/hrmapp/frame/static/css/style.css">
    <link rel="icon" href="/hrmapp/frame/static/image/code.png">
</head>
<body>

<!-- layout admin -->
<div class="layui-layout layui-layout-admin"> <!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
    <!-- header -->
    <div class="layui-header my-header">
        <a href="index.html">
            <div class="my-header-logo">人事管理系统</div>
        </a>

        <!-- 顶部左侧添加选项卡监听 -->
        <ul class="layui-nav" lay-filter="side-top-left">
        </ul>

        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;">&#12288;${sessionScope.user_session.loginname } </a>
                <dl class="layui-nav-child">
                    <!-- <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe621;</i>登录页</a></dd>
                    <dd><a href="javascript:;" href-url="demo/map.html"><i class="layui-icon">&#xe621;</i>图表</a></dd> -->
                    <dd><a href="/"><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side">
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="side-main">
               <li class="layui-nav-item  layui-nav-itemed">
                    <a href="javascript:;"><i class="layui-icon">&#xe620;</i>用户管理</a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a href="javascript:;" href-url="user/selectUser"><i class="layui-icon">&#xe621;</i>用户查询</a></dd>
                        <dd><a href="javascript:;" href-url="user/addUser?flag=1"><i class="layui-icon">&#xe621;</i>添加用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>部门管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="dept/selectDept"><i class="layui-icon">&#xe621;</i>部门查询</a></dd>
                        <dd><a href="javascript:;" href-url="dept/addDept?flag=1"><i class="layui-icon">&#xe621;</i>添加部门</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>职位管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="job/selectJob"><i class="layui-icon">&#xe621;</i>职位查询</a></dd>
                        <dd><a href="javascript:;" href-url="job/addJob?flag=1"><i class="layui-icon">&#xe621;</i>添加职位</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>员工管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="employee/selectEmployee"><i class="layui-icon">&#xe621;</i>员工查询</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login2.html"><i class="layui-icon">&#xe621;</i>员工部门</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>公告管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/register.html"><i class="layui-icon">&#xe621;</i>公告查询</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login2.html"><i class="layui-icon">&#xe621;</i>公告部门</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe628;</i>下载中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/register.html"><i class="layui-icon">&#xe621;</i>文档查询</a></dd>
                        <dd><a href="javascript:;" href-url="demo/login2.html"><i class="layui-icon">&#xe621;</i>上传文档</a></dd>
                    </dl>
                </li>
                <!-- <li class="layui-nav-item"><a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=ad6ba602ae228be2222ddb804086e0cfa42da3d74e34b383b665c2bec1adfc6e"><i class="layui-icon">&#xe61e;</i>加入群下载源码</a></li> -->
            </ul>

        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body" style="margin-top: 30px">
        <iframe src="user/selectUser" frameborder="0"></iframe>
    </div>
    <!-- footer -->
    <div class="layui-footer my-footer">
        
    </div>
</div>

<!-- 右键菜单 -->
<div class="my-dblclick-box none">
    <table class="layui-tab dblclick-tab">
        <tr class="card-refresh">
            <td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
        </tr>
    </table>
</div>

<script type="text/javascript" src="/hrmapp/frame/layui/layui.js"></script>
<script type="text/javascript" src="/hrmapp/frame/static/js/vip_comm.js"></script>
<script type="text/javascript">

</script>
</body>
</html>