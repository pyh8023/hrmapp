<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/hrmapp/frame/layui/css/layui.css">
	<link rel="stylesheet" href="/hrmapp/frame/static/css/style.css">
	<link rel="icon" href="/hrmapp/frame/static/image/code.png">
</head>
<body class="body">
<form class="layui-form" method="post" name="empform"  action="selectDept">
	<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">部门名称</label>
			<div class="layui-input-inline">
				<input type="text" name="username"  autocomplete="off" class="layui-input"  value="${requestScope.selectDept.name}">
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline">
				<button class="layui-btn" lay-submit="" lay-filter="search">搜索</button>
				<button class="layui-btn" lay-submit="" lay-filter="delete">删除</button>
			</div>
		</div>
	</div>

	<table class="layui-table" id="user_table" >
		<colgroup>
			<col width="100">
			<col width="150">
			<col width="150">
			<col>
		</colgroup>
		<thead>
		<tr align="center">
			<td><input type="checkbox" lay-skin="primary" title="" lay-filter="all"></td>
			<td>部门名称</td>
			<td>详细信息</td>
			<td align="center">操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.depts}" var="dept" varStatus="stat">
			<tr id="data_${stat.index}" align="center">
				<td><input type="checkbox" lay-skin="primary" value="${user.id}" id="box_${stat.index}" lay-filter="item"></td>
				<td>${dept.name }</td>
				<td>${dept.remark }</td>
				<td align="center" width="40px;"><a class="layui-btn layui-btn-xs my-link" href-url="updateDept?flag=1&id=${dept.id}"  href="javascript:;" target="_blank">修改</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</form>
<div id="pageDemo"></div>
</body>
<script type="text/javascript" src="/hrmapp/frame/layui/layui.js"></script>
<script type="text/javascript" src="/hrmapp/frame/static/js/vip_public.js"></script>
<script type="text/javascript">
    layui.use(['form','table','laypage'], function(){
        var form = layui.form
            ,layer = layui.layer
            , laypage = layui.laypage
            ,$ = layui.jquery;

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            ,count: 6 //总页数${requestScope.pageModel.recordCount}
            ,skin: '#1E9FFF' //自定义选中色值
            ,skip: true //开启跳页
            ,limit: ${requestScope.pageModel.pageSize} //每页条数
            ,curr: ${requestScope.pageModel.pageIndex}
            ,jump: function(obj, first){
                if(!first){
                    window.location = "selectDept?pageIndex="+obj.curr+"&name=${requestScope.selectDept.name}";
                }
            }
        });

        form.on('checkbox(all)', function(data){
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });

        //删除
        form.on('submit(delete)', function () {
            var checked_box = $('table tbody input[type="checkbox"]:checked');
            var selectValue ="";
            checked_box.each(function(j) {
                if (j == 0) {
                    selectValue += $(this).val();
                }else{
                    selectValue += ","+ $(this).val();
                }
            });
            if (selectValue == ""){
                layer.alert("请选择部门！");
            }else{
                window.location = "removeUser?ids=" + selectValue;
            }
            return false;
        });
    });
</script>
</html>