<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>
	<title>用户管理</title>
	<meta name='keywords' content='权限管理'>
	<meta name='description' content='菜单，部门，区域等资源权限于一体的按钮级权限管理系统'>
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
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
	    				// 获取分页条
	    				var pageBar = data.pageBar;
	    				// 获取用户列表
	    				data = JSON.parse(data.jsonObj);
	    				var htmlTable = "";
	    				if (data.length != 0) {
	    					for (var i = 0; i < data.length; i++) {
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
		    					htmlTable = htmlTable + "<a href='${ctx}/sysmgr/gotoUserEdit.action?editFlag=2&userId=" + data[i].userId + 
		    						"'>修改</a> <a href='javascript:void(0);' onclick='userMgr.delUser(" + data[i].userId + ")'>删除</a>";
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
        					userMgr.getUserListPage(1,10);
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
					<a id="deptButton" href="javascript:showDept();" class="btn">
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
	<!-- 用于放置分页条 -->
	<div class="pagination" id="userPageBar">

	</div>
	<script type="text/javascript">
		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		// 点击之前会触发的事件
		function beforeClick(treeId, treeNode) {
		};

		// 选中某个菜单项后会触发的操作
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("deptTree");
			nodes = zTree.getSelectedNodes();
			var parentName = "";
			var parentId = "";

			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				parentName += nodes[i].name + ",";
				parentId += nodes[i].id + ",";
			}
			if (parentName.length > 0 ) parentName = parentName.substring(0, parentName.length-1);
			$("#deptName").attr("value", parentName);

			if (parentId.length > 0 ) parentId = parentId.substring(0, parentId.length-1);
			$("#deptId").attr("value", parentId);

			hideDept();
		};

		function showDept() {
			var parent = $("#deptName");
			var parentOffset = $("#deptName").offset();
			$("#deptContent").css({left:parentOffset.left + "px",
				top:parentOffset.top + parent.outerHeight() + "px"}).slideToggle("fast");
			$("html").bind("click", onBodyDown);
		};

		function hideDept() {
			$("#deptContent").slideToggle("fast");
			$("html").unbind("click", onBodyDown);
		};

		function onBodyDown(event) {
			if (!(event.target.id == "deptButton" || event.target.id == "deptName" ||
				event.target.id == "deptContent" || $(event.target).parents("#deptContent").length>0)) {
				hideDept();
			}
		};

		$(document).ready(function(){
			// 页面一刷新就加载zTree
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/loadDeptTree.action",
				// 设为同步的，否则数据加载完成了无法赋值给页面
				async : false,
				dataType : "json",
				success : function(data) {
					var deptArray = JSON.parse(data.jsonObj);
					var deptTree = $.fn.zTree.init($("#deptTree"), setting, deptArray);
					deptTree.expandAll(true);
				}
			});
		});
	</script>

	<!-- 盛放部门树的容器 -->
	<div id="deptContent" class="menuContent" style="display:none; position:absolute;">
		<ul id="deptTree" class="ztree" style="margin-top:0; width:180px;background:#f1f1f1;"></ul>
	</div>
</body>
</html>