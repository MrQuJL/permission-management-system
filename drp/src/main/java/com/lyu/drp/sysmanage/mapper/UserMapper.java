package com.lyu.drp.sysmanage.mapper;

import com.lyu.drp.sysmanage.entity.User;

/**
 * 类名称: 用户数据映射
 * 类描述: 用于对用户的增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.UserMapper
 * @author 曲健磊
 * @date 2018年1月15日 下午11:41:01
 * @version V1.0
 */
public interface UserMapper {
	
	public User loginUser(String loginName, String password);
	
}
