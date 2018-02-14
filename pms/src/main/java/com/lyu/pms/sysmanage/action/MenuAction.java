package com.lyu.pms.sysmanage.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.pms.sysmanage.dto.MenuDto;
import com.lyu.pms.sysmanage.dto.TreeDto;
import com.lyu.pms.sysmanage.entity.Menu;
import com.lyu.pms.sysmanage.service.IMenuService;
import com.lyu.pms.util.TreeUtils;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称: 菜单管理业务控制类
 * 类描述: 对菜单的一些增删改查
 * 全限定性类名: com.lyu.pms.sysmanage.action.MenuAction
 * @author 曲健磊
 * @date 2018年1月27日 下午2:35:46
 * @version V1.0
 */
public class MenuAction {
	// 增删改的返回信息
	private String message;
	// 编辑页面的标识，1为新增，0为修改
	private int editFlag;
	// 获取菜单id
	private Long menuId;
	// 父级菜单的id
	private Long parentId;
	// 待修改的菜单对象
	private MenuDto menu;
	// 通过spring自动注入
	private IMenuService menuService;
	// 菜单列表
	private List<Menu> menuList;
	// 返回页面的json对象
	private String jsonObj;
	
	/**
	 * 前往菜单列表
	 * @param 
	 * @return
	 */
	public String gotoMenuList() {
		// 获取当前的用户id
		Long userId = UserUtils.getCurrentUserId();
		
		// 因为此功能没有查询按钮，进入功能的时候就要提前查询出所有数据，以对象的形式返回页面
		List<Menu> menuListUnSort = menuService.getMenuListByUserId(userId);
		List<Menu> returnMenuList = new ArrayList<Menu>();
		
		// ---temp为了测试添加菜单，临时查询全部的菜单列表---
		menuListUnSort = menuService.getAllMenuList();
		// ---temp---
		
		// 因为前台的tree table必须按菜单的层级顺序显示才能达到顺序效果，所以要先递归排序一下
//		MenuUtils.sortMenuList(returnMenuList, menuListUnSort, 0L);
		TreeUtils.sortTreeList(returnMenuList, menuListUnSort, 0L);
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
		} else if (parentId != null) { //添加下级菜单
			this.menu = menuService.getMenuDetailById(parentId);
			// 当前查询的是id为"parent_id"的menu，但是我们是要添加子菜单，所以要把当前查询出来的
			// menu的parent_id修改为它的id
			Long curPId = this.menu.getId();
			String curPName = this.menu.getName();
			// 在添加下级菜单的时候，只希望在菜单添加页面显示出父级菜单的名字和id(hidden)
			// 但是如果仅仅这样把menu发往前台的话，就会把当前菜单的所有信息都展示出来，就会让用户
			// 误以为是修改，所以要把一些信息置空
			this.menu = null;
			this.menu = new MenuDto();
			this.menu.setParentId(curPId);
			this.menu.setParentName(curPName);
		}
		// 否则为正常的添加菜单
		return "menuEdit";
	}
	
	/**
	 * 构造二三级菜单
	 * @param 
	 * @return
	 */
	public String menuNavi() {
		this.menuList = menuService.getAllMenuList();
		return "success";
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
			// 如果没有选择父部门那么默认父部门为0
			if (menu.getParentId() == null) {
				menu.setParentId(0L);
			}
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
	
	public String confirmHasSubMenu() {
		// 1.先查看该菜单下面是否有子菜单
		this.message = "yes";
		boolean flag = menuService.hasSubMenu(menuId);
		if (!flag) {
			this.message = "no";
		}
		return "success";
	}
	
	public String delMenu() {
		this.message = "删除菜单失败，请联系系统管理员!";
		// 1.删除菜单
		boolean flag = menuService.delMenu(menuId);
		if (flag) {
			this.message = "删除菜单成功!";
		}
		
		return "success";
	}
	
	/**
	 * 获取属性菜单的数据
	 * @param 
	 * @return
	 */
	public String getMenuTree(){		
		List<TreeDto> mapList  = new ArrayList<TreeDto>();
		List<Menu> menuList = this.menuService.getMenuListByUserId(UserUtils.getCurrentUserId());
		
		if (menuId != null) {
			// 获取当前菜单的所有子孙菜单
			List<Menu> childsMenuList = new ArrayList<Menu>();
			this.menuService.getAllChildsMenuByPId(childsMenuList, menuId);
			// 把自己也加进来
			childsMenuList.add(menuService.getMenuDetailById(menuId));
			
			for(Menu menu:menuList){
				// 如果是通过修改按钮进入的该功能，则不能把当前的菜单和它的子菜单展示出来，否则会造成死循环
				// 检查当前菜单是否是它自己或者它的孩子
				boolean flag = false;
				
				for (Menu child : childsMenuList) {
					if (child.getId() == menu.getId()) {
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					TreeDto node = new TreeDto();
					node.setId(menu.getId());
					node.setParentId(menu.getParentId());
					node.setName(menu.getName());
					
					mapList.add(node);
				}
			}
		} else {
			for(Menu menu:menuList){
				TreeDto node = new TreeDto();
				node.setId(menu.getId());
				node.setParentId(menu.getParentId());
				node.setName(menu.getName());
				
				mapList.add(node);
			}
		}
		
		this.jsonObj = JSONArray.toJSONString(mapList);
		return "success";
	}

	/**
	 * 一系列的setter和getter方法
	 */
	
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
	
	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
