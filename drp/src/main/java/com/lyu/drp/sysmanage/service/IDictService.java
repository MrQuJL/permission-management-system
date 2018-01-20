package com.lyu.drp.sysmanage.service;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Dict;

/**
 * 类名称: 字典业务处理接口
 * 类描述: 用于提供对字典的一些服务
 * 全限定性类名: com.lyu.drp.sysmanage.service.IDictService
 * @author 曲健磊
 * @date 2018年1月19日 下午8:16:16
 * @version V1.0
 */
public interface IDictService {
	
	/**
	 * 获得字典列表
	 * @param type 字典的类型
	 * @param description 字典的描述
	 * @return 字典列表
	 */
	public List<Dict> getDictList(String type, String description);
	
	/**
	 * 获取所有的字典类型
	 * @param 
	 * @return
	 */
	public List<String> getDictTypeList();
	
}
