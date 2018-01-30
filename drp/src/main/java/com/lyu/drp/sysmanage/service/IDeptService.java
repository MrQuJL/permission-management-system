package com.lyu.drp.sysmanage.service;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Dept;

/**
 * 类名称: 部门服务接口
 * 类描述: 为部门服务
 * 全限定性类名: com.lyu.drp.sysmanage.service.IDeptService
 * @author 曲健磊
 * @date 2018年1月30日 下午4:40:38
 * @version V1.0
 */
public interface IDeptService {
	
	/**
	 * 获取所有的部门列表
	 * @param 
	 * @return
	 */
	public List<Dept> getAllDeptList();
	
}
