package com.lyu.drp.sysmanage.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lyu.drp.sysmanage.dto.LogDto;
import com.lyu.drp.sysmanage.service.ILogService;

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
	// 日志服务类
	private ILogService logService;
	
	/**
	 * 获取日志列表
	 * @param 
	 * @return
	 */
	public String getLogList() {
		
		LogDto logDto = JSON.parseObject(this.jsonObj, LogDto.class);
		
		List<LogDto> logList = logService.getLogList(logDto);
		
		this.jsonObj = JSON.toJSONString(logList);
		
		return "success";
	}

	
	/**
	 * 处理前往日志列表的请求
	 * @param 
	 * @return
	 */
	public String gotoLogList() {
		return "success";
	}
	
	/**
	 * 一系列的setter和getter方法
	 */
	
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

	public ILogService getLogService() {
		return logService;
	}

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	
}
