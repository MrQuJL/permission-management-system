package com.lyu.drp.sysmanage.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.lyu.drp.common.dto.PageParam;
import com.lyu.drp.common.util.PageUtils;
import com.lyu.drp.sysmanage.dto.UserDto;
import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.service.IRoleService;
import com.lyu.drp.sysmanage.service.IUserService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 用户管理业务控制类
 * 类描述: 用于用户的管理
 * 全限定性类名: com.lyu.drp.sysmanage.action.UserAction
 * @author 曲健磊
 * @date 2018年1月14日 下午11:00:15
 * @version V1.0
 */
public class UserAction {
	// log4j打印日志
	Logger logger = Logger.getLogger(this.getClass());
	// 前台接收 的旧密码
	private String oldPassword;
	// 接收前台的新密码
	private String newPassword;
	// 标记是新增(1)用户还是修改(2)用户
	private String editFlag;
	// 用于为ajax返回提示消息
	private String message;
	// 用于发往前台的json字符串
	private String jsonObj;
	// 角色id列表
	private String roleIds;
	// 接收分页信息
	private PageParam pageParam;
	// 封装好的分页条
	private String pageBar;
	// 接收前台的查询条件
	private UserDto userDto;
	// 所有的角色列表
	private List<Role> roleList;
	// 用户服务类
	private IUserService userService;
	// 角色服务类
	private IRoleService roleService;
	
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
	 * 进入用户列表页面
	 * @param 
	 * @return
	 */
	public String gotoUserList() {
		return "success";
	}
	
	/**
	 * 进入用户编辑(add/update)页面
	 * @param 
	 * @return
	 */
	public String gotoUserEdit() {
		
		this.roleList = this.roleService.getAllRoleList();
		
		return "success";
	}
	
	/**
	 * 处理查询用户的请求
	 * @param 
	 * @return
	 */
	public String getUserListPage() {
		
		PageInfo<UserDto> pageInfo = this.userService.getUserListPageByUserDto(this.userDto, this.pageParam);
		
		List<UserDto> userList = pageInfo.getList();
		
		this.jsonObj = JSONArray.toJSONString(userList);
		
		this.pageBar = PageUtils.pageStr(pageInfo, "userMgr.getUserListPage");
		
		return "success";
	}
	
	
	/**
	 * 修改用户密码
	 * @param 
	 * @return
	 */
	public String saveChangePwd() {
		// 1.通过session或者其他组件获取当前用户对象
//		Long userId = 1L;
		Long userId = UserUtils.getCurrentUserId();
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
	 * 根据id获取用户的详细信息，包括部门名称，id
	 * @param 
	 * @return
	 */
	public String getUserInfoById() {
		// 1.通过session或者其他组件获取当前用户对象
//		Long userId = 1L;
		Long userId = UserUtils.getCurrentUserId();
		UserDto userDto = userService.getUserInfoById(userId);
		// 2.将java对象转换成json字符串
		String obj = JSON.toJSONString(userDto);
		this.jsonObj = obj;
		return "getUserInfoById";
	}
	
	/**
	 * 添加/修改用户个人信息
	 * @param 
	 * @return
	 */
	public String saveUserInfo() {
		System.out.println(this.jsonObj);
		System.out.println(this.roleIds);
		User user = JSON.parseObject(jsonObj, User.class);
		List<Long> roleIds = JSON.parseArray(this.roleIds, Long.class);
		
		if (user.getUserId() == null) { // 新增
			boolean falg = this.userService.addUser(user, roleIds);
			if (falg) {
				this.message = "添加用户信息成功！";
			} else {
				this.message = "添加用户信息失败！";
			}
		} else { // 修改
			boolean falg = userService.saveUserInfo(user);
			if (falg) {
				this.message = "更新用户信息成功！";
			} else {
				this.message = "更新用户信息失败！";
			}
		}
		
		return "success";
	}
	
	/**
	 * 一系列的setter和getter方法
	 */
	
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

	public String getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
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
	
	public PageParam getPageParam() {
		return pageParam;
	}

	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}

	public String getPageBar() {
		return pageBar;
	}

	public void setPageBar(String pageBar) {
		this.pageBar = pageBar;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

}
