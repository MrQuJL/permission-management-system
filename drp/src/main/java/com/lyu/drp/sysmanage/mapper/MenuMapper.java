package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Menu;

/**
 * 类名称: 用于访问菜单的mapper接口
 * 类描述: 对菜单的一些增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.MenuMapper
 * @author 曲健磊
 * @date 2018年1月23日 下午12:39:09
 * @version V1.0
 */
public interface MenuMapper {
	
	/**
	 * 根据用户的id获取用户所能够操作的用户列表
	 * @param userId 用户的id
	 * @return 
	 */
	public List<Menu> getMenuListByUser(Long userId);
	
}
