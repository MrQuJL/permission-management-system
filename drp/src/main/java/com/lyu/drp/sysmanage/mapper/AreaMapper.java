package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Area;

/**
 * 类名称: 区域mapper
 * 类描述: 用于操作区域的数据
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.AreaMapper
 * @author 曲健磊
 * @date 2018年2月2日 上午10:17:29
 * @version V1.0
 */
public interface AreaMapper {
	
	/**
	 * 查询全部的区域列表
	 * @param 
	 * @return
	 */
	public List<Area> getAllAreaList();
	
	/**
	 * 添加区域
	 * @param 
	 * @return
	 */
	public int saveArea(Area area);
	
}
