package com.lyu.drp.sysmanage.action;

/**
 * 类名称: 日志业务控制类
 * 类描述: 用于对处理对日志的一些请求
 * 全限定性类名: com.lyu.drp.sysmanage.action.LogAction
 * @author 曲健磊
 * @date 2018年2月11日 下午6:38:06
 * @version V1.0
 */
public class LogAction {
	// 发送给前台的日志列表的json字符串数组
	private String jsonObj;
	// 返回给前台的提示信息
	private String message;
	
	
	
	
	
	
	
	
	
	
	public String getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
