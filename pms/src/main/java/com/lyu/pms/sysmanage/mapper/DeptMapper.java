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
	 * 获取部门的详细信息，包括父部门的名称...
	 * @param 
	 * @return
	 */
	DeptDto getDeptDetailById(Long deptId);
	
	/**
	 * 获取所有的部门列表
	 * @param 
	 * @return
	 */
	List<Dept> getAllDeptList();
	
	/**
	 * 根据角色id获取该角色所拥有的部门权限
	 * @param 
	 * @return
	 */
	List<Dept> getDeptListByRoleId(Long roleId);
	
	/**
	 * 获取当前部门的所有子部门id
	 * @param 
	 * @return
	 */
	List<Long> getAllSubDeptIds(Long parentId);
	
	/**
	 * 统计父部门下面的子部门的数量
	 * @param 
	 * @return
	 */
	int countSubDeptByPId(Long deptId);
	
	/**
	 * 添加部门
	 * @param 
	 * @return
	 */
	int saveDept(Dept dept);
	
	/**
	 * 修改部门
	 * @param 
	 * @return
	 */
	int updateDept(Dept dept);
	
	/**
	 * 删除部门（逻辑删除）
	 * @param 
	 * @return
	 */
	int delDept(Long deptId);
	
}
