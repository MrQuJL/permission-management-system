package com.lyu.drp.sysmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.UserDto;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.mapper.UserMapper;
import com.lyu.drp.sysmanage.service.IUserService;
import com.lyu.drp.util.EncryptUtil;

/**
 * 类名称: 用户业务服务类
 * 类描述: 用于对用户的验证，更新用户信息
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.UserService
 * @author 曲健磊
 * @date 2018年1月16日 上午11:29:41
 * @version V1.0
 */
@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	public static final int HASH_ITERATIONS = 1024;
	
    public static final int SALT_SIZE = 8;
	
	@Override
	public User loginUser(String loginName) {
		// 1.用户名是否存在
//		User user = userMapper.loginUser(loginName, password);
//		// 2.密码是否存在
//		if (user != null) {
//			boolean flag = this.validatePassword(password, user.getPassword());
//			if (flag) {
//				return user;
//			} else {
//				return null;
//			}
//		}
//		// 3.返回
		
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
	public boolean saveUserInfo(User user) {
		boolean flag = false;
		int rows = userMapper.saveUserInfo(user);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}
	
	@Override
    public String encyptPassword (String plainPassword) {
    	//生成一个随机数 ，所谓的salt 盐
        byte[] salt = EncryptUtil.generateSalt(SALT_SIZE);
        //盐+密码   进行sha1的加密
        byte[] hashPass = EncryptUtil.sha1(plainPassword.getBytes(), salt, HASH_ITERATIONS);
        //盐可逆加密+(盐+密码 sha1加密后)可逆加密
        return EncryptUtil.encodeHex(salt) + EncryptUtil.encodeHex(hashPass);
    } 
	
    @Override
    public boolean validatePassword (String plainPsd, String encryptPsd) {
    	//将密文逆转 ，截取 salt盐的明文,用hex加密后的密文的位数是原位数的2倍
    	byte[] salt = EncryptUtil.decodeHex(encryptPsd.substring(0, SALT_SIZE*2));
    	//重新拼凑 盐+密码   进行sha1的加密
        byte[] hashPass = EncryptUtil.sha1(plainPsd.getBytes(), salt, HASH_ITERATIONS);
        
        System.out.println("DB密码：" + encryptPsd);
        System.out.println("原   密码：" + EncryptUtil.encodeHex(salt) + EncryptUtil.encodeHex(hashPass));
        
        return encryptPsd.equals(EncryptUtil.encodeHex(salt) + EncryptUtil.encodeHex(hashPass));
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
    
}
