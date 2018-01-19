package com.lyu.drp.sysmanage.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.entity.Dict;
import com.lyu.drp.sysmanage.service.IDictService;

/**
 * 类名称: 字典管理业务控制类
 * 类描述: 对字典的一些增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.action.DictAction
 * @author 曲健磊
 * @date 2018年1月19日 下午7:52:22
 * @version V1.0
 */
public class DictAction {
	// 发送给前台的字典列表的json字符串数组
	private String jsonObj;
	// 字典的类型
	private String type;
	// 字典的描述
	private String description;
	// 整合包会负责注入
	private IDictService dictService;
	
	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IDictService getDictService() {
		return dictService;
	}

	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}

	/**
	 * 进入字典列表页面
	 * @param 
	 * @return
	 */
	public String gotoDictList() {
		return "dictList";
	}
	
	/**
	 * 进入字典编辑页面
	 * @param 
	 * @return
	 */
	public String gotoDictEdit() {
		return "dictEdit";
	}
	
	/**
	 * 获取字典列表
	 * @param 
	 * @return
	 */
	public String getDictList() {
		
		if (dictService == null) {
			System.out.println("dictService is null");
		}
		
		if (StringUtils.isEmpty(type)) {
			type = null;
		}
		
		if (StringUtils.isEmpty(description)) {
			description = null;
		}
		
		List<Dict> dictList = dictService.getDictList(type, description);
		
		this.jsonObj =  JSONArray.toJSONString(dictList);
		
		
		
		return "success";
	}
	
}