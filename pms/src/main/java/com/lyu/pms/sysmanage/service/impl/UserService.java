package com.lyu.pms.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.dto.UserDto;
import com.lyu.pms.sysmanage.entity.User;
import com.lyu.pms.sysmanage.entity.UserToRole;
import com.lyu.pms.sysmanage.mapper.UserMapper;
import com.lyu.pms.sysmanage.mapper.UserToRoleMapper;
import com.lyu.pms.sysmanage.service.IUserService;
import com.lyu.pms.util.EncryptUtils;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称: 用户业务服务类
 * 类描述: 用于对用户的验证，更新用户信息
 * 全限定性类名: com.lyu.pms.sysmanage.service.impl.UserService
 * @author 曲健磊
 * @date 2018年1月16日 上午11:29:41
 * @version V1.0
 */
@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserToRoleMapper userToRoleMapper;
	
	public static final int HASH_ITERATIONS = 1024;
	
    public static final int SALT_SIZE = 8;
	
	@Override
	public User loginUser(String loginName) {
		return this.userMapper.loginUser(loginName);
	}
	
	@Override
	public User getUserById(Long userId) {
		return userMapper.getUserById(userId);
	}
	
	@Override
	public UserDto getUserInfoById(Long userId) {
		return userMapper.getUserInfoById(userId);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean saveUserInfo(User user, List<Long> roleIds) {
		boolean flag = false;
		
		user.setUpdateBy(UserUtils.getCurrentUserId());
		user.setUpdateDate(new Date());
		
		if (roleIds != null) { // 修改用户的角色
			// 先将用户的所有角色删除
			this.userToRoleMapper.deleteUserToRole(user.getUserId());
			// 再向里面统一添加角色
			for (Long roleId : roleIds) {
				UserToRole userToRole = new UserToRole();
				userToRole.setUserId(user.getUserId());
				userToRole.setRoleId(roleId);
				this.userToRoleMapper.addUserToRole(userToRole);
			}
		}
		
		int rows = userMapper.saveUserInfo(user);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}
	
	@Override
    public String encyptPassword (String plainPassword) {
    	//生成一个随机数 ，所谓的salt 盐
        byte[] salt = EncryptUtils.generateSalt(SALT_SIZE);
        //盐+密码   进行sha1的加密
        byte[] hashPass = EncryptUtils.sha1(plainPassword.getBytes(), salt, HASH_ITERATIONS);
        //盐可逆加密+(盐+密码 sha1加密后)可逆加密
        return EncryptUtils.encodeHex(salt) + EncryptUtils.encodeHex(hashPass);
    } 
	
    @Override
    public boolean validatePassword (String plainPsd, String encryptPsd) {
    	//将密文逆转 ，截取 salt盐的明文,用hex加密后的密文的位数是原位数的2倍
    	byte[] salt = EncryptUtils.decodeHex(encryptPsd.substring(0, SALT_SIZE*2));
    	//重新拼凑 盐+密码   进行sha1的加密
        byte[] hashPass = EncryptUtils.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
        
        System.out.println("DB密码：" + encryptPsd);
        System.out.println("原   密码：" + EncryptUtils.encodeHex(salt) + EncryptUtils.encodeHex(hashPass));
        
        return encryptPsd.equals(EncryptUtils.encodeHex(salt) + EncryptUtils.encodeHex(hashPass));
    }

    @Override
	public boolean updateUserPassword(Long userId, String newPassword) {
		// 记录修改密码是否成功
		boolean flag = false;
		// 对新密码加密
		String encryptPassword = this.encyptPassword(newPassword);
		// 返回受影响的行数，大于0更新成功
		int rows = userMapper.updateUserPassword(userId, encryptPassword);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public PageInfo<UserDto> getUserListPageByUserDto(UserDto userDto, PageParam pageParam) {
		if (StringUtils.isEmpty(userDto.getUserName())	) {
			userDto.setUserName(null);
		}
		// 此处进行分页查询
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		
		List<UserDto> userList = this.userMapper.getUserListByUserDto(userDto);
		
		PageInfo<UserDto> pageInfo = new PageInfo<UserDto>(userList);
		
		return pageInfo;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean addUser(User user, List<Long> roleIds) {
		boolean flag = false;
		if (user == null) return flag;
		
		user.setUpdateBy(UserUtils.getCurrentUserId());
		user.setUpdateDate(new Date());
		// 还要给用户一个默认密码
		user.setPassword(this.encyptPassword("123"));
		
		// 向用户表中添加一条用户记录
		int rows = userMapper.addUser(user);
		// 还要向用户-角色对应表中添加记录
		
		if (rows > 0) {
			if (roleIds.size() > 0) {
				int count = 0;
				for (Long roleId : roleIds) {
					UserToRole userToRole = new UserToRole();
					userToRole.setUserId(user.getUserId());
					userToRole.setRoleId(roleId);
					int tempRows = userToRoleMapper.saveUserToRole(userToRole);
					if (tempRows > 0) {
						count++;
					}
				}
				// 记录全部添加成功，则把标记位置为true
				if (count == roleIds.size()) {
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public List<UserToRole> listRoleByUId(Long userId) {
		return this.userToRoleMapper.listRoleByUId(userId);
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean delUser(Long userId) {
		boolean flag = false;
		// 1.先删除用户-角色对应表中的数据
		this.userToRoleMapper.deleteUserToRole(userId);
		// 2.再删除用户表中的数据(逻辑删除)
		int rows = this.userMapper.delUser(userId);
		
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}
    
}
