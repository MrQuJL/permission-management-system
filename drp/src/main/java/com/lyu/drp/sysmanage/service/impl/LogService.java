package com.lyu.drp.sysmanage.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.LogDto;
import com.lyu.drp.sysmanage.entity.Log;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.mapper.LogMapper;
import com.lyu.drp.sysmanage.mapper.UserMapper;
import com.lyu.drp.sysmanage.service.ILogService;
import com.lyu.drp.util.UserUtils;

@Service("logService")
public class LogService implements ILogService {

	@Autowired
	private LogMapper logMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Log> getLogList(LogDto logDto) {
		return logMapper.getLogList(logDto);
	}

	@Override
	public boolean insertLog(Log log) {
		// 获取当前操作的用户id
		Long currentUserId = UserUtils.getCurrentUserId();
		// 获取当前用户
		User user = userMapper.getUserById(currentUserId);
		// 设置该日志的时间
		log.setCreateDate(new Timestamp(System.currentTimeMillis()).toString());
		log.setCreateBy(user.getUserName());
		log.setDeptId(user.getDeptId());
		
		boolean flag = false;
		int rows = logMapper.saveLog(log);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delLog(Long logId) {
		boolean flag = false;
		int rows = logMapper.delLog(logId);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

}
