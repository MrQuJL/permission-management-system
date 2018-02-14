package com.lyu.pms.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.pms.sysmanage.entity.UserToRole;
import com.lyu.pms.sysmanage.mapper.UserToRoleMapper;
import com.lyu.pms.sysmanage.service.IUserToRoleService;

@Service("userToRoleService")
public class UserToRoleService implements IUserToRoleService {
	@Autowired
	private UserToRoleMapper userToRoleMapper;
	
	@Override
	public List<UserToRole> listRoleByUId(Long userId) {
		
		return userToRoleMapper.listRoleByUId(userId);
	}

}
