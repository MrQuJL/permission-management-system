package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Dict;

/**
 * 类名称: 字典映射接口
 * 类描述: 用于访问字典数据库中字典表的一些信息
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.DictMapper
 * @author 曲健磊
 * @date 2018年1月19日 下午8:37:10
 * @version V1.0
 */
public interface DictMapper {
	
	/**
	 * 根据类型和描述获得字典列表
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
