package com.lyu.drp.sysmanage.action;

/**
 * 类名称: 部门业务控制类
 * 类描述: 用于管理部门的业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.DeptAction
 * @author 曲健磊
 * @date 2018年1月30日 下午2:22:18
 * @version V1.0
 */
public class DeptAction {
	// 发送给前台的部门列表的json字符串数组
	private String jsonObj;
	// 返回给前台的消息
	private String message;
	// 修改(2)还是增加(1)
	private Integer editFlag;
	
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

	/**
	 * 进入部门列表
	 * @param 
	 * @return
	 */
	public String gotoDeptList() {
		
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
	
}
