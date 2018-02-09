package com.lyu.drp.sysmanage.mapper;

import com.lyu.drp.sysmanage.entity.RoleToArea;

/**
 * 类名称: 角色-区域对应表mapper接口
 * 类描述: 封装了对角色-区域对应表的一些操作
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.RoleToAreaMapper
 * @author 曲健磊
 * @date 2018年2月5日 下午2:19:45
 * @version V1.0
 */
public interface RoleToAreaMapper {
	
	/**
	 * 新增角色-区域对应表的一条记录
	 * @param 
	 * @return
	 */
	int saveRoleToArea(RoleToArea roleToArea);
	
	/**
	 * 根据角色id，删除角色-区域对应表的记录
	 * @param 
	 * @return
	 */
	int deleteRoleToArea(Long roleId);
	
	/**
	 * 根据区域id，删除角色-区域对应表的记录
	 * @param 
	 * @return
	 */
	int deleteRoleToAreaByAId(Long areaId);
	
}
