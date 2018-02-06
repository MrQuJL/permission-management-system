package com.lyu.drp.sysmanage.action;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lyu.drp.sysmanage.entity.Area;
import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.entity.Menu;
import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.service.IAreaService;
import com.lyu.drp.sysmanage.service.IDeptService;
import com.lyu.drp.sysmanage.service.IMenuService;
import com.lyu.drp.sysmanage.service.IRoleService;

/**
 * 类名称: 角色业务控制类
 * 类描述: 用于管理角色的业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.RoleAction
 * @author 曲健磊
 * @date 2018年2月4日 下午4:10:24
 * @version V1.0
 */
public class RoleAction {
	// 发送给前台的角色列表的json字符串数组
	private String jsonObj;
	// 返回给前台的消息
	private String message = "hi";
	// 修改(2)还是增加(1)
	private Integer editFlag;
	// 角色id
	private Long roleId;
	// 查询到的角色列表
	private List<Role> roleList;
	// 角色信息
	private Role role;
	
	// 接收前台选中的菜单，部门区域
	private String menuIds;
	private String deptIds;
	private String areaIds;
	
	// 当前用户所拥有的所有菜单，部门，区域
	private List<Menu> menuList;
	private List<Dept> deptList;
	private List<Area> areaList;
	
	private IRoleService roleService;
	
	private IMenuService menuService;
	private IDeptService deptService;
	private IAreaService areaService;
	
	/**
	 * 处理前往角色列表页面的请求
	 * @param 
	 * @return
	 */
	public String gotoRoleList() {
		this.roleList = roleService.getAllRoleList();
		return "success";
	}
	
	/**
	 * 处理前往角色编辑页面的请求
	 * @param 
	 * @return
	 */
	public String gotoRoleEdit() {
		// 无论是新增还是修改都要显示出当前用户所拥有的所有资源
		this.menuList = menuService.getAllMenuList();
		this.deptList = deptService.getAllDeptList();
		this.areaList = areaService.getAllAreaList();
		
		if (editFlag == 2) { // 修改的话要选中默认选中用户已经拥有的权限资源
			// 调用service查询一下角色的id为roleId的角色信息
			this.role = this.roleService.getRoleById(this.roleId);
		}		
		return "success";
	}
	
	/**
	 * 保存角色，新增的话editFlag为1，修改为2
	 * @param 
	 * @return
	 */
	public String saveRole() {
		Role role = JSON.parseObject(jsonObj, Role.class);
		
		List<Long> menuIds = JSON.parseArray(this.menuIds, Long.class);
		List<Long> deptIds = JSON.parseArray(this.deptIds, Long.class);
		List<Long> areaIds = JSON.parseArray(this.areaIds, Long.class);
		
		if (role.getId() == null) { // 新增
			boolean flag = this.roleService.saveRole(role, menuIds, deptIds, areaIds);
			
			if (flag) {
				this.message = "添加角色成功";
			} else {
				this.message = "添加角色失败";
			}
			
		} else { // 修改
			boolean flag = this.roleService.updateRole(role, menuIds, deptIds, areaIds);
			
			if (flag) {
				this.message = "修改角色成功";
			} else {
				this.message = "修改角色失败";
			}
		}
		
		return "success";
	}
	
	/**
	 * 删除角色
	 * @param 
	 * @return
	 */
	public String delRole() {
		boolean flag = this.roleService.delRole(this.roleId);
		
		if (flag) {
			this.message = "删除角色成功";
		} else {
			this.message = "删除角色失败";
		}
		
		return "success";
	}
	
	/**
	 * 一系列的setter和getter方法
	 */
	
	public String getJsonObj() {
		return jsonObj;
	}
	
	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getEditFlag() {
		return editFlag;
	}
	
	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public IAreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(String areaIds) {
		this.areaIds = areaIds;
	}
	
}
