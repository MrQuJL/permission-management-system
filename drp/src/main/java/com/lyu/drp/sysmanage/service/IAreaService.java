package com.lyu.drp.sysmanage.service;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Area;

/**
 * 类名称: 区域服务类接口
 * 类描述: 封装了一些对区域的操作
 * 全限定性类名: com.lyu.drp.sysmanage.service.IAreaService
 * @author 曲健磊
 * @date 2018年2月2日 上午10:23:38
 * @version V1.0
 */
public interface IAreaService {
	
	/**
	 * 查询全部的区域列表
	 * @param 
	 * @return
	 */
	public List<Area> getAllAreaList();
	
	/**
	 * 新增区域
	 * @param 
	 * @return
	 */
	public boolean saveArea(Area area);
	
}
