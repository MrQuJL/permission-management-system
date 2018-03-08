package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.lyu.pms.sysmanage.dto.DeptDto;
import com.lyu.pms.sysmanage.entity.Dept;

/**
 * 类名称: 部门服务接口
 * 类描述: 为部门服务
 * 全限定性类名: com.lyu.pms.sysmanage.service.IDeptService
 * @author 曲健磊
 * @date 2018年1月30日 下午4:40:38
 * @version V1.0
 */
public interface IDeptService {
	
	/**
	 * 获取部门的详细信息，包括父部门的名称...
	 * @param deptId 部门id
	 * @return id为deptId的部门的详细信息
	 */
	DeptDto getDeptDetailById(Long deptId);
	
	/**
	 * 获取所有的部门列表
	 * @return 所有的部门列表
	 */
	List<Dept> getAllDeptList();
	
	/**
	 * 通过用户id查询当前用户所能够操作的部门
	 * @param userId 用户id
	 * @return 当前用户所能够拥有的部门列表
	 */
	List<Dept> getDeptListByUId(Long userId);
	
	/**
	 * 获取当前部门的所有子子孙孙...部门的id
	 * @param parentId 当前部门id
	 * @return 当前部门的所有子孙部门的id
	 */
	List<Long> getAllSubDeptIds(Long parentId);
	
	/**
	 * 判断父部门下面是否有子部门
	 * @param parentId 部门id
	 * @return true则当前部门下有子部门，false则没有
	 */
	boolean hasSubDept(Long parentId);
	
	/**
	 * 添加部门
	 * @param dept 待添加的部门
	 * @return true则添加成功，false则添加失败
	 */
	boolean saveDept(Dept dept);
	
	/**
	 * 修改部门
	 * @param dept 待修改的部门
	 * @return true则修改成功，false则修改失败
	 */
	boolean updateDept(Dept dept);
	
	/**
	 * 删除指定id部门
	 * @param deptId 待删除的部门id
	 * @return true则删除成功，false则删除失败
	 */
	boolean delDept(Long deptId);
	
}
