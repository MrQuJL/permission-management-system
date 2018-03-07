package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.dto.DeptDto;
import com.lyu.pms.sysmanage.entity.Dept;

/**
 * 类名称: 部门映射接口
 * 类描述: 用于访问部门表的一些信息
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.DeptMapper
 * @author 曲健磊
 * @date 2018年1月30日 下午4:08:25
 * @version V1.0
 */
public interface DeptMapper {
	
	/**
	 * 获取部门的详细信息，包括父部门的名称
	 * @param deptId
	 * @return 部门的详细信息
	 */
	DeptDto getDeptDetailById(Long deptId);
	
	/**
	 * 获取所有的部门列表
	 * @return 所有的部门列表
	 */
	List<Dept> getAllDeptList();
	
	/**
	 * 根据角色id获取该角色所拥有的部门
	 * @param roleId 角色id
	 * @return 该角色所能够操作的部门
	 */
	List<Dept> getDeptListByRoleId(Long roleId);
	
	/**
	 * 获取当前部门的所有子部门id
	 * @param parentId 父部门的id
	 * @return parentId下的所有子部门的id
	 */
	List<Long> getAllSubDeptIds(Long parentId);
	
	/**
	 * 统计父部门下面的子部门的数量
	 * @param deptId 当前的部门id
	 * @return deptId部门下的所有子部门的数量
	 */
	int countSubDeptByPId(Long deptId);
	
	/**
	 * 添加部门
	 * @param dept 要添加的部门
	 * @return 受影响的记录数，1表示添加成功，否则失败
	 */
	int saveDept(Dept dept);
	
	/**
	 * 修改部门
	 * @param dept 要修改的部门
	 * @return 受影响的记录数，1表示修改成功，否则失败
	 */
	int updateDept(Dept dept);
	
	/**
	 *  删除部门（逻辑删除）
	 * @param deptId 要逻辑删除的部门
	 * @return 受影响的记录数，1表示逻辑删除成功，否则失败
	 */
	int delDept(Long deptId);
	
}
