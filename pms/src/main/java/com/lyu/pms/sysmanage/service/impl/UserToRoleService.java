package com.lyu.pms.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.pms.sysmanage.entity.UserToRole;
import com.lyu.pms.sysmanage.mapper.UserToRoleMapper;
import com.lyu.pms.sysmanage.service.IUserToRoleService;

/**
 * 类名称：用户角色对应关系服务类
 * 全限定性类名: com.lyu.pms.sysmanage.service.impl.UserToRoleService
 * @author 曲健磊
 * @date 2018年3月8日下午4:06:30
 * @version V1.0
 */
@Service("userToRoleService")
public class UserToRoleService implements IUserToRoleService {
	@Autowired
	private UserToRoleMapper userToRoleMapper;
	
	@Override
	public List<UserToRole> listRoleByUId(Long userId) {
		
		return userToRoleMapper.listRoleByUId(userId);
	}

}
