<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
<title>用户管理</title>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
    	var userMgr = {
    		// 获取分页后的用户列表
	    	getUserListPage : function(pageNo, pageSize) {
	    		loading("正在查询...");
	    		var deptId = $("#deptId").val();
	    		var userName = $("#userName").val();
	    		$.ajax({
	    			type : "post",
	    			url : "${ctx}/sysmgr/getUserListPage.action",
	    			data : {"userDto.deptId":deptId,"userDto.userName":userName,
	    				"pageParam.pageNo":pageNo,"pageParam.pageSize":pageSize},
	    			dataType : "json",
	    			success : function(data) {
	    				top.$.jBox.closeTip();
	    				//alert(data.jsonObj);
	    				// 获取分页条
	    				var pageBar = data.pageBar;
	    				// 获取用户列表
	    				data = JSON.parse(data.jsonObj);
	    				var htmlTable = "";
	    				if (data.length != 0) {
	    					for (var i = 0; i < data.length; i++) {
		    					//console.log(data[i].id+ "," +data[i].userName);
		    					htmlTable = htmlTable + "<tr>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].userName;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].loginName;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].name;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].phone;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].mobile;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].email;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + "<a href='${ctx}/sysmgr/gotoUserEdit.action?userId=" + data[i].id + 
		    						"'>修改</a> <a href='javascript:void(0);' onclick='userMgr.delUser(" + data[i].id + ")'>删除</a>";
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "</tr>";
		    				}
	    				} else {
	    					htmlTable = "没有查询到数据";
	    				}
	    				$("#userTable").find("tbody").html(htmlTable);
	    				$("#userPageBar").html(pageBar);
	    			},
	    			error : function(data, status, errorThrown) {
	    				top.$.jBox.closeTip();
	    				alert("您没有权限操作此功能，请联系系统管理员进行授权");
	    			}
	    		});
	    	},
    		// 删除用户
    		delUser : function(userId) {
    			if (confirm("您确定要删除该用户吗？")) {
    				loading('正在提交，请稍等...');
        			$.ajax({
        				type : "post",
        				url : "${ctx}/sysmgr/delUser.action",
        				data : {"userId" : userId},
        				dataType : "json",
        				success : function(data){
    	    				alert(data.message);
        				},
        				complete : function(){
        					top.$.jBox.closeTip();
        					// 删除完了之后重新查询一下用户列表
        					userMgr.getUserList();
        				}
        			});
    			}
    		}
    	};
    </script>
</head>
<body>
	<ul class="nav nav-tabs">
	    <li class="active"><a href="javascript:void(0);">用户列表</a></li>
	    <li><a href="${ctx}/sysmgr/gotoUserEdit.action?editFlag=1">用户添加</a></li>
	</ul>
	<form id="saveUserForm" class="breadcrumb form-search" action="#" method="post">
	   <ul class="ul-form">
			<li>
				<label>部门名称：</label>
				<div class="input-append">
					<input id="deptId" name="deptId" class="input-small" type="hidden" value=""/>
					<input id="deptName" name="deptName" readonly="readonly" type="text" value="" class="input-small"/>
					<a id="officeButton" href="javascript:void(0);" class="btn">
						&nbsp;<i class="icon-search"></i>&nbsp;
					</a>&nbsp;&nbsp;
				</div>
			</li>
			<li>
				<label>用户名称：</label>
				<input id="userName" name="userName" class="input-medium" type="text" value="" maxlength="50"/>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="button" value="查询" onclick="userMgr.getUserListPage(1,10);"/>
			</li>
		</ul>
	</form>

	<table id="userTable" class="table table-striped table-bordered table-condensed">
	    <thead>
	    <tr>
	        <th>用户名称</th>
	        <th>登录名称</th>
	        <th>所属部门</th>
	        <th>电话</th>
	        <th>手机</th>
	        <th>邮箱</th>
	        <th>操作</th>
	    </tr>
	    </thead>
	    <tbody>
			
	    </tbody>
	</table>

	<div class="pagination" id="userPageBar">
		<!-- 
		<ul>
			<li class="disabled"><a href="javascript:">&#171; 上一页</a></li>
			<li class="active"><a href="javascript:">1</a></li>
			<li class="disabled"><a href="javascript:">下一页 &#187;</a></li>
			<li class="disabled controls">
				<a href="javascript:">
					当前 <input type="text" value="1" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(this.value,15,'');" onclick="this.select();"/>
					 / <input type="text" value="15" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/>
					 条，共 0 条
				</a>
			</li>
		</ul>
		<div style="clear:both;"></div>
		-->
	</div>
</body>
</html>