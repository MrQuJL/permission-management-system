package com.lyu.pms.sysmanage.mapper;

import com.lyu.pms.sysmanage.entity.RoleToDept;

/**
 * 类名称: 角色-部门对应表mapper接口
 * 类描述: 封装了对角色-部门对应表的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.RoleToDeptMapper
 * @author 曲健磊
 * @date 2018年2月5日 下午2:16:00
 * @version V1.0
 */
public interface RoleToDeptMapper {
	
	/**
	 * 新增角色-部门对应表的一条记录
	 * @param roleToDept
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推
	 */
	int saveRoleToDept(RoleToDept roleToDept);
	
	/**
	 * 根据角色id，删除角色-部门对应表的记录
	 * @param roleId 角色id
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推，角色可能对应多个部门权限，所以受影响的行数
	 * 可能不止一行
	 */
	int deleteRoleToDept(Long roleId);
	
	/**
	 * 根据部门id，删除角色-部门对应表的记录
	 * @param deptId 部门id
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推，一个部门也可能被多个角色所拥有，所以受影响的行数
	 * 可能不止一行
	 */
	int deleteRoleToDeptByDId(Long deptId);
	
}
