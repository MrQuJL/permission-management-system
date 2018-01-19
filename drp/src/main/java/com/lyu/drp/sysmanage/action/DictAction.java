package com.lyu.drp.sysmanage.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.lyu.drp.sysmanage.dto.UserDto;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.service.IUserService;

/**
 * 类名称: 字典管理业务控制类
 * 类描述: 对字典的一些增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.action.DictAction
 * @author 曲健磊
 * @date 2018年1月19日 下午7:52:22
 * @version V1.0
 */
public class DictAction {

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
	
}
