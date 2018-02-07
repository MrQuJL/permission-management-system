package com.lyu.drp.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.entity.UserToRole;
import com.lyu.drp.sysmanage.mapper.UserToRoleMapper;
import com.lyu.drp.sysmanage.service.IUserToRoleService;

@Service("userToRoleService")
public class UserToRoleService implements IUserToRoleService {
	@Autowired
	private UserToRoleMapper userToRoleMapper;
	
	@Override
	public List<UserToRole> listRoleByUId(Long userId) {
		
		return userToRoleMapper.listRoleByUId(userId);
	}

}
