package com.lyu.drp.sysmanage.action;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.service.IDeptService;

/**
 * 类名称: 部门业务控制类
 * 类描述: 用于管理部门的业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.DeptAction
 * @author 曲健磊
 * @date 2018年1月30日 下午2:22:18
 * @version V1.0
 */
public class DeptAction {
	// 查询到的部门列表集合
	private List<Dept> deptList;
	// 发送给前台的部门列表的json字符串数组
	private String jsonObj;
	// 返回给前台的消息
	private String message;
	// 修改(2)还是增加(1)
	private Integer editFlag;
	
	private IDeptService deptService;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}

	public Integer getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	/**
	 * 进入部门列表
	 * @param 
	 * @return
	 */
	public String gotoDeptList() {
		// 查询所有的部门列表
		List<Dept> deptList = deptService.getAllDeptList();
		
		this.deptList = deptList;
		
		return "gotoDeptList";
	}
	
	/**
	 * 进入部门编辑页面
	 * @param 
	 * @return
	 */
	public String gotoDeptEdit() {
		
		return "gotoDeptEdit";
	}
	
	
	/**
	 * 加载部门树
	 * @param 
	 * @return
	 */
	public String getDeptTree() {
		
		
		return "success";
	}
	
	
}
