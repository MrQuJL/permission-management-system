package com.lyu.pms.sysmanage.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.common.util.PageUtils;
import com.lyu.pms.sysmanage.dto.LogDto;
import com.lyu.pms.sysmanage.service.ILogService;

/**
 * 类名称: 日志业务控制类
 * 类描述: 用于对处理对日志的一些请求
 * 全限定性类名: com.lyu.pms.sysmanage.action.LogAction
 * @author 曲健磊
 * @date 2018年2月11日 下午6:38:06
 * @version V1.0
 */
public class LogAction {
	// 发送给前台的日志列表的json字符串数组
	private String jsonObj;
	// 返回给前台的提示信息
	private String message;
	// 获取当前日期
	private String currentDate;
	// 分页信息
	private PageParam pageParam;
	// 返回的分页条对象
	private String pageBar;
	// 日志服务类
	private ILogService logService;
	
	/**
	 * 获取日志列表
	 * @param 
	 * @return
	 */
	public String getLogListPage() {
		
		LogDto logDto = JSON.parseObject(this.jsonObj, LogDto.class);
		
		PageInfo<LogDto> pageInfo = logService.getLogListPage(logDto, this.pageParam);
		
		this.jsonObj = JSON.toJSONString(pageInfo.getList());
		
		this.pageBar = PageUtils.pageStr(pageInfo, "logMgr.getLogListPage");
		
		return "success";
	}

	
	/**
	 * 处理前往日志列表的请求
	 * @param 
	 * @return
	 */
	public String gotoLogList() {
		// 获取当前日期
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.currentDate = sdf.format(date);
		
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

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public PageParam getPageParam() {
		return pageParam;
	}

	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}

	public String getPageBar() {
		return pageBar;
	}

	public void setPageBar(String pageBar) {
		this.pageBar = pageBar;
	}

	public ILogService getLogService() {
		return logService;
	}

	public void setLogService(ILogService logService) {
		this.logService = logService;
	}
	
}
