package com.lyu.drp.sysmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.dto.DeptDto;
import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.service.IDeptService;
import com.lyu.drp.util.DeptUtils;

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
	// 部门编号
	private Long deptId;
	// 部门的详细信息
	private DeptDto deptDto;
	
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

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public DeptDto getDeptDto() {
		return deptDto;
	}

	public void setDeptDto(DeptDto deptDto) {
		this.deptDto = deptDto;
	}

	/**
	 * 进入部门列表
	 * @param 
	 * @return
	 */
	public String gotoDeptList() {
		// 查询所有的部门列表
		List<Dept> deptList = deptService.getAllDeptList();
		List<Dept> returnDepts = new ArrayList<Dept>();
		
		// 对部门进行排序
		DeptUtils.sortDeptList(returnDepts, deptList, 0L);
		
		this.deptList = returnDepts;
		
		return "gotoDeptList";
	}
	
	/**
	 * 进入部门编辑页面
	 * @param 
	 * @return
	 */
	public String gotoDeptEdit() {
		if (editFlag == 2) { // 修改
			// 查询指定id的部门的明细信息
			this.deptDto = deptService.getDeptDetailById(deptId);
		}
		
		return "gotoDeptEdit";
	}
	
	/**
	 * 新增 或修改部门
	 * @param 
	 * @return
	 */
	public String saveDept() {
		Dept dept = JSON.parseObject(this.jsonObj, Dept.class);
		
		if (dept.getId() == null) { // 解析出来的部门对象的id为空说明是新增
			boolean flag = false;
			flag = deptService.saveDept(dept);
			
			if (flag) {
				this.message = "添加部门成功";
			} else {
				this.message = "添加部门失败";
			}
		} else { // 修改
			boolean flag = false;
			flag = deptService.updateDept(dept);
			
			if (flag) {
				this.message = "修改部门成功";
			} else {
				this.message = "修改部门失败";
			}
		}
		
		return "success";
	}
	
	public String confirmHasSubDept() {
		// 判断deptId下面是否有子部门
		boolean flag = deptService.hasSubDept(deptId);
		if (flag) {
			this.message = "yes";
		} else {
			this.message = "no";
		}
		return "success";
	}
	
	/**
	 * 加载部门树
	 * @param 
	 * @return
	 */
	public String getDeptTree() {
		List<Dept> deptList = deptService.getAllDeptList();
		List<Map<String, Object>> deptListMap = new ArrayList<Map<String, Object>>();
		
		for (Dept dept : deptList) {
			Map<String, Object> deptMap = new HashMap<String, Object>();
			deptMap.put("id", dept.getId());
			deptMap.put("pId", dept.getParentId());
			deptMap.put("name", dept.getName());
			deptListMap.add(deptMap);
		}
		
		this.jsonObj = JSONArray.toJSONString(deptListMap);
		
		return "success";
	}
	
}
