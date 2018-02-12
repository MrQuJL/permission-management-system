<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
	<title>日志管理</title>
	
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
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
				value="2018-02-11" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
			<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="2018-02-11" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="btnSubmit" class="btn btn-primary" onclick="logMgr.getLogLilst();" type="button" value="查询"/>&nbsp;&nbsp;
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

<div class="pagination"><ul>
<li class="disabled"><a href="javascript:">&#171; 上一页</a></li>
<li class="active"><a href="javascript:">1</a></li>
<li class="disabled"><a href="javascript:">下一页 &#187;</a></li>
<li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(this.value,15,'');" onclick="this.select();"/> / <input type="text" value="15" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 0 条</a></li>
</ul>
<div style="clear:both;"></div></div>
	<script type="text/javascript">
		var logMgr = {
			// 查询日志记录
			getLogLilst : function() {
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
					data : {"jsonObj" : JSON.stringify(jsonObj)},
					dataType : "json",
					success : function(data) {
						alert(data.jsonObj);
						var logList = JSON.parse(data.jsonObj);
						var htmlTable = "";
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
						$("#logTable").find("tbody").html(htmlTable);
						top.$.jBox.closeTip();
					}
				});
			}
		}
	</script>
</body>
</html>