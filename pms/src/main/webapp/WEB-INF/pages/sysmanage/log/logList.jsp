<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>
	<title>日志管理</title>
	<meta name='keywords' content='权限管理'>
	<meta name='description' content='菜单，部门，区域等资源权限于一体的按钮级权限管理系统'>
	<%@ include file="/WEB-INF/pages/include/head.jsp"%>
</head>
<body>
	<form id="logForm" class="breadcrumb form-search" action="#" method="post">
		<div>
			<label>操作类型：</label><input id="type" name="type" type="text" maxlength="50" class="input-mini" value=""/>
			<label>用户名称：</label><input id="createBy" name="createBy" type="text" maxlength="50" class="input-mini" value=""/>
		</div>
		<div style="margin-top:8px;">
			<label>日期范围：&nbsp;</label><input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="${currentDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="${currentDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<shiro:hasPermission name="sys:log:view">
				<input id="btnSubmit" class="btn btn-primary" onclick="logMgr.getLogListPage(1,10);" type="button" value="查询"/>&nbsp;&nbsp;
			</shiro:hasPermission>
		</div>
	</form>

	<table id="logTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>操作用户</th>
				<th>所在部门</th>
				<th>操作内容</th>
				<th>操作类型</th>
				<th>操作时间</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>

	<div class="pagination">
		<div style="clear:both;"></div>
	</div>
	<script type="text/javascript">
		var logMgr = {
			// 查询日志记录
			getLogListPage : function(pageNo, pageSize) {
				var type = $("#type").val();
				var createBy = $("createBy").val();
				var beginDate = $("#beginDate").val();
				var endDate = $("#endDate").val();
				var jsonObj = {};
				jsonObj["type"] = type;
				jsonObj["createBy"] = createBy;
				jsonObj["beginDate"] = beginDate;
				jsonObj["endDate"] = endDate;
				
				loading("正在查询，请稍后...");
				
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/getLogList.action",
					data : {"jsonObj" : JSON.stringify(jsonObj), "pageParam.pageNo" : pageNo, "pageParam.pageSize" : pageSize},
					dataType : "json",
					success : function(data) {
						//alert(data.jsonObj);
						var logList = JSON.parse(data.jsonObj);
						var htmlTable = "";
						if (logList.length != 0) {
							for (var i = 0; i < logList.length; i++) {
								htmlTable = htmlTable + "<tr>";
								htmlTable = htmlTable + "<td>";
								htmlTable = htmlTable + logList[i].createBy;
								htmlTable = htmlTable + "</td>";
								htmlTable = htmlTable + "<td>";
								htmlTable = htmlTable + logList[i].deptName;
								htmlTable = htmlTable + "</td>";
								htmlTable = htmlTable + "<td>";
								htmlTable = htmlTable + logList[i].title;
								htmlTable = htmlTable + "</td>";
								htmlTable = htmlTable + "<td>";
								htmlTable = htmlTable + logList[i].type;
								htmlTable = htmlTable + "</td>";
								htmlTable = htmlTable + "<td>";
								htmlTable = htmlTable + logList[i].createDate;
								htmlTable = htmlTable + "</td>";
								htmlTable = htmlTable + "</tr>";
							}
						} else {
							htmlTable = "没有查询到记录";
						}
						$("#logTable").find("tbody").html(htmlTable);
						$(".pagination").html(data.pageBar);
						top.$.jBox.closeTip();
					}
				});
			}
		}
	</script>
</body>
</html>