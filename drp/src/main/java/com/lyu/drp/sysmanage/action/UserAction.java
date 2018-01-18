package com.lyu.drp.sysmanage.action;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.lyu.drp.sysmanage.dto.UserDto;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.service.IUserService;

/**
 * 类名称: 用户管理业务控制类
 * 类描述: 用于用户的管理
 * 全限定性类名: com.lyu.drp.sysmanage.action.UserAction
 * @author 曲健磊
 * @date 2018年1月14日 下午11:00:15
 * @version V1.0
 */
public class UserAction {
	// 前台接收 的旧密码
	private String oldPassword;
	// 接收前台的新密码
	private String newPassword;
	// 用于为ajax返回提示消息
	private String message;
	// 用于接收返回的json字符串
	private String jsonObj;
	// spring和struts2的整合包会将该属性以名称匹配的凡是注入
	private IUserService userService;
	
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

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
	
	/**
	 * 修改用户密码
	 * @param 
	 * @return
	 */
	public String saveChangePwd() {
		// 1.通过session或者其他组件获取当前用户对象
		Long userId = 1L;
		User user = userService.getUserById(userId);
		// 2.校验输入的密码是否与用户当前的密码匹配
		boolean validOldPass = userService.validatePassword(oldPassword, user.getPassword());
		if (!validOldPass) {
			this.message = "修改密码失败，输入密码错误";
		} else {
			if (StringUtils.isNotEmpty(newPassword)) {
				// 修改用户密码
				if (userService.updateUserPassword(userId, newPassword)) {
					this.message = "修改密码成功";
				} else {
					this.message = "修改密码失败，请联系系统管理员";
				}
			} else {
				this.message = "新密码不能为空";
			}
		}
		return "saveChangePwd";
	}
	
	/**
	 * 修改用户个人信息
	 * @param 
	 * @return
	 */
	public String getUserInfoById() {
		// 1.通过session或者其他组件获取当前用户对象
		Long userId = 1L;
		UserDto userDto = userService.getUserInfoById(userId);
		// 2.将java对象转换成json字符串
		String obj = JSON.toJSONString(userDto);
		this.jsonObj = obj;
		return "getUserInfoById";
	}
	
}
