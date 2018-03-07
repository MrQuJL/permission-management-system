package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.dto.AreaDto;
import com.lyu.pms.sysmanage.entity.Area;

/**
 * 类名称: 区域mapper
 * 类描述: 用于操作区域的数据
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.AreaMapper
 * @author 曲健磊
 * @date 2018年2月2日 上午10:17:29
 * @version V1.0
 */
public interface AreaMapper {
	
	/**
	 * 获取区域的详细信息,包括父级区域的名称
	 * @param id 区域的id
	 * @return 对应的区域信息
	 */
	AreaDto getAreaDetailById(Long id);
	
	/**
	 * 查询全部的区域列表
	 * @return 全部的区域列表
	 */
	List<Area> getAllAreaList();
	
	/**
	 * 根据角色id获取区域列表
	 * @param roleId 角色id
	 * @return 该角色id所拥有的区域列表
	 */
	List<Area> getAreaListByRoleId(Long roleId);
	
	/**
	 * 通过父级区域id获取所有的子区域
	 * @param pId 父级区域id
	 * @return 该父级区域的所有子区域
	 */
	List<Area> getSubAreaByPId(Long pId);
	
	/**
	 * 统计当前区域下的直接子区域的数量
	 * @param areaId 区域id
	 * @return 当前区域下的直接子区域的数量
	 */
	int countSubArea(Long areaId);
	
	/**
	 * 添加区域
	 * @param area 要添加到数据库中的记录
	 * @return 受影响的行数，返回值为1则添加成功，否则失败
	 */
	int saveArea(Area area);
	
	/**
	 * 修改区域
	 * @param area 要修改的区域
	 * @return 受影响的行数，返回值为1则修改成功，否则失败
	 */
	int updateArea(Area area);
	
	/**
	 * 删除子区域（逻辑删除）
	 * @param areaId 要被删除的区域id
	 * @return 受影响的行数，返回值为1则修改成功，否则失败
	 */
	int delArea(Long areaId);
	
}
