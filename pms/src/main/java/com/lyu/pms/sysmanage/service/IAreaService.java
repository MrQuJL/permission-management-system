package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.lyu.pms.sysmanage.dto.AreaDto;
import com.lyu.pms.sysmanage.entity.Area;

/**
 * 类名称: 区域服务类接口
 * 类描述: 封装了一些对区域的操作
 * 全限定性类名: com.lyu.pms.sysmanage.service.IAreaService
 * @author 曲健磊
 * @date 2018年2月2日 上午10:23:38
 * @version V1.0
 */
public interface IAreaService {
	
	/**
	 * 获取区域的详细信息,包括父级区域的名称
	 * @param id 区域id
	 * @return 区域的详细信息
	 */
	AreaDto getAreaDetailById(Long id);
	
	/**
	 * 查询全部的区域列表
	 * @return 所有的区域列表
	 */
	List<Area> getAllAreaList();
	
	/**
	 * 通过用户id查询当前用户所拥有的区域
	 * @param userId 用户id
	 * @return 该用户所拥有的区域列表
	 */
	List<Area> getAreaListByUId(Long userId);
	
	/**
	 * 通过父级区域id获取所有的子孙区域
	 * @param pId 区域id
	 * @return 获取id为pId的区域的所有子孙区域
	 */
	List<Area> getAllSubAreasByPId(Long pId);
	
	/**
	 * 当前区域下是否有子区域
	 * @param areaId 区域id
	 * @return true则当前区域下有子区域，false则没有
	 */
	boolean hasSubArea(Long areaId);
	
	/**
	 * 新增区域
	 * @param area 待新增的区域
	 * @return true则新增区域成功，否则失败
	 */
	boolean saveArea(Area area);
	
	/**
	 * 修改区域
	 * @param area 待修改的区域
	 * @return true则修改区域成功，否则失败
	 */
	boolean updateArea(Area area);
	
	/**
	 * 删除区域（逻辑删除）
	 * @param areaId 待删除的区域
	 * @return true则删除区域成功，否则失败
	 */
	boolean delArea(Long areaId);
	
}
