package com.lyu.drp.sysmanage.action;

/**
 * 类名称: 用户管理业务控制类
 * 类描述: 用于用户的管理
 * 全限定性类名: com.lyu.drp.sysmanage.action.UserAction
 * @author 曲健磊
 * @date 2018年1月14日 下午11:00:15
 * @version V1.0
 */
public class UserAction {
	
	/**
	 * 进入用户个人信息页面
	 * @param 
	 * @return
	 */
	public String userInfo() {
		return "userInfo";
	}
	
	/**
	 * 进入用户密码修改页面
	 * @param 
	 * @return
	 */
	public String changePwd() {
		return "changePwd";
	}
	
}
