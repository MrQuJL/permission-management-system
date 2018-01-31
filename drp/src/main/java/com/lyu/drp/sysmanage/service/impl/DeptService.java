package com.lyu.drp.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.DeptDto;
import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.mapper.DeptMapper;
import com.lyu.drp.sysmanage.service.IDeptService;
import com.lyu.drp.util.UserUtils;

@Service("deptService")
public class DeptService implements IDeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public DeptDto getDeptDetailById(Long deptId) {
		return deptMapper.getDeptDetailById(deptId);
	}
	
	@Override
	public List<Dept> getAllDeptList() {
		return deptMapper.getAllDeptList();
	}

	@Override
	public boolean hasSubDept(Long parentId) {
		boolean flag = true;
		int count = deptMapper.countSubDeptByPId(parentId); 
		if (count == 0) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public boolean saveDept(Dept dept) {
		boolean flag = false;
		dept.setUpdateBy(UserUtils.getCurrentUserId().toString());
		dept.setUpdateDate(new Date());
		
		int rows = deptMapper.saveDept(dept);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateDept(Dept dept) {
		boolean flag = false;
		dept.setUpdateBy(UserUtils.getCurrentUserId().toString());
		dept.setUpdateDate(new Date());
		
		int rows = deptMapper.updateDept(dept);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

}
