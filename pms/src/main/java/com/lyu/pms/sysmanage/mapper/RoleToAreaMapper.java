package com.lyu.pms.sysmanage.mapper;

import com.lyu.pms.sysmanage.entity.RoleToArea;

/**
 * 类名称: 角色-区域对应表mapper接口
 * 类描述: 封装了对角色-区域对应表的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.RoleToAreaMapper
 * @author 曲健磊
 * @date 2018年2月5日 下午2:19:45
 * @version V1.0
 */
public interface RoleToAreaMapper {
	
	/**
	 * 新增角色-区域对应表的一条记录
	 * @param roleToArea 要添加的角色区域对应表对象
	 * @return 受影响的行数，1表示添加成功，否则表示失败
	 */
	int saveRoleToArea(RoleToArea roleToArea);
	
	/**
	 * 根据角色id，删除角色-区域对应表的记录
	 * @param roleId 角色id
	 * @return 受影响的行数，1表示删除成功，否则表示失败
	 */
	int deleteRoleToArea(Long roleId);
	
	/**
	 * 根据区域id，删除角色-区域对应表的记录
	 * @param areaId 区域id
	 * @return 受影响的行数，因为可能有多个角色拥有该区域的权限，删除的受影响的行数取决于与该区域相关的角色数量
	 */
	int deleteRoleToAreaByAId(Long areaId);
	
}
