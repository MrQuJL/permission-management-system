package com.lyu.drp.sysmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.dto.MenuDto;
import com.lyu.drp.sysmanage.entity.Menu;
import com.lyu.drp.sysmanage.service.IMenuService;
import com.lyu.drp.util.MenuUtils;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 菜单管理业务控制类
 * 类描述: 对菜单的一些增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.action.MenuAction
 * @author 曲健磊
 * @date 2018年1月27日 下午2:35:46
 * @version V1.0
 */
public class MenuAction {
	// log4j日志
	private Logger log = Logger.getLogger(MenuAction.class);
	// 增删改的返回信息
	private String message;
	// 编辑页面的标识，1为新增，0为修改
	private int editFlag;
	// 获取菜单id
	private Long menuId;
	// 待修改的菜单对象
	private MenuDto menu;
	// 通过spring自动注入
	private IMenuService menuService;
	// 菜单列表
	private List<Menu> menuList;
	//获取弹出属性菜单页面所需要的当前菜单的id
	private String extId;
	// 返回页面的json对象
	private String jsonObj;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(int editFlag) {
		this.editFlag = editFlag;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public MenuDto getMenu() {
		return menu;
	}

	public void setMenu(MenuDto menu) {
		this.menu = menu;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	
	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getExtId() {
		return extId;
	}

	public void setExtId(String extId) {
		this.extId = extId;
	}
	
	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}

	/**
	 * 前往菜单列表
	 * @param 
	 * @return
	 */
	public String gotoMenuList() {
		// 获取当前的用户id
		Long userId = UserUtils.getCurrentUserId();
		
		// 因为此功能没有查询按钮，进入功能的时候就要提前查询出所有数据，以对象的形式返回页面
		List<Menu> menuListUnSort = menuService.getMenuListByUser(userId);
		List<Menu> returnMenuList = new ArrayList<Menu>();
		
		// ---temp为了测试添加菜单，临时查询全部的菜单列表---
		menuListUnSort = menuService.getAllMenuList();
		// ---temp---
		
		// 因为前台的tree table必须按菜单的层级顺序显示才能达到顺序效果，所以要先递归排序一下
		MenuUtils.sortMenuList(returnMenuList, menuListUnSort, 0L);
		this.menuList = returnMenuList;
		return "menuList";
	}

	/**
	 * 前往菜单编辑页面
	 * @param 
	 * @return
	 */
	public String gotoMenuEdit() {
		if (editFlag == 2) { // 修改
			// 根据id查询一下菜单
			this.menu = menuService.getMenuDetailById(menuId);
		}
		return "menuEdit";
	}
	
	
	/**
	 * 保存菜单（新增，修改）
	 * @param 
	 * @return
	 */
	public String saveMenu() {
		// 1.将前台发来的json类型的菜单字符串解析成java对象
		Menu menu = JSON.parseObject(jsonObj, Menu.class);
		
		if (menu.getId() == null) { // id为空则为新增
			this.message = "新增菜单失败";
			boolean flag = menuService.saveMenu(menu);
			if (flag) {
				this.message = "新增菜单成功!";
			}
		} else { // id不为空则为修改
			this.message = "修改菜单失败";
			boolean flag = menuService.updateMenu(menu);
			if (flag) {
				this.message = "修改菜单成功!";
			}
		}
		
		return "success";
	}
	
	public String delMenu() {
		
		this.message = "功能正在开发中，请稍安勿躁...";
		
		return "success";
	}
	
	/**
	 * 获取属性菜单的数据
	 * @param 
	 * @return
	 */
	public String getMenuTree(){		
		List<Map<String,Object>> mapList  = new ArrayList<Map<String,Object>>();
		List<Menu> menuList = this.menuService.getMenuListByUser(UserUtils.getCurrentUserId());
		for(Menu menu:menuList){	
			if(StringUtils.isNotEmpty(extId)||
					!menu.getId().equals(extId)){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("id", menu.getId());
				map.put("pId", menu.getParentId());
				map.put("name", menu.getName());
				mapList.add(map);
			}
		}
		this.jsonObj = JSONArray.toJSONString(mapList);
		return "success";
	}

}
