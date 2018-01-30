package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Dept;

/**
 * 类名称: 部门映射接口
 * 类描述: 用于访问部门表的一些信息
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.DeptMapper
 * @author 曲健磊
 * @date 2018年1月30日 下午4:08:25
 * @version V1.0
 */
public interface DeptMapper {
	
	/**
	 * 获取所有的部门列表
	 * @param 
	 * @return
	 */
	public List<Dept> getAllDeptList();
	
	/**
	 * 新增部门
	 * @param 
	 * @return
	 */
	public int saveDept(Dept Dept);
	
	/**
	 * 修改部门
	 * @param 
	 * @return
	 */
	public int updateDept(Dept Dept);
	
	/**
	 * 删除部门表(逻辑删除)
	 * @param 
	 * @return
	 */
	public int delDept(Long deptId);
	
}
