package com.lyu.drp.sysmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.dto.DeptDto;
import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.service.IDeptService;
import com.lyu.drp.util.TreeUtils;

/**
 * 
 * 类名称: 区域业务控制类
 * 类描述: 用于管理区域的业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.AreaAction
 * @author 曲健磊
 * @date 2018年2月2日 上午10:02:25
 * @version V1.0
 */
public class AreaAction {
	// 发送给前台的部门列表的json字符串数组
	private String jsonObj;
	// 返回给前台的消息
	private String message;
	// 修改(2)还是增加(1)
	private Integer editFlag;
	
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
	
	public Integer getEditFlag() {
		return editFlag;
	}
	
	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}
	
	/**
	 * 处理前往区域列表页面的请求
	 * @param 
	 * @return
	 */
	public String gotoAreaList() {
		
		return "success";
	}
	
	/**
	 * 处理前往区域编辑页面的请求
	 * @param 
	 * @return
	 */
	public String gotoAreaEdit() {
		
		return "success";
	}
	
}
