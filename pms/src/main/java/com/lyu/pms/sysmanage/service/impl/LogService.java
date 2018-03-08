package com.lyu.pms.sysmanage.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.dto.LogDto;
import com.lyu.pms.sysmanage.entity.Log;
import com.lyu.pms.sysmanage.entity.User;
import com.lyu.pms.sysmanage.mapper.LogMapper;
import com.lyu.pms.sysmanage.mapper.UserMapper;
import com.lyu.pms.sysmanage.service.ILogService;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称：日志服务类
 * 全限定性类名: com.lyu.pms.sysmanage.service.impl.LogService
 * @author 曲健磊
 * @date 2018年3月8日下午4:05:42
 * @version V1.0
 */
@Service("logService")
public class LogService implements ILogService {

	@Autowired
	private LogMapper logMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public PageInfo<LogDto> getLogListPage(LogDto logDto, PageParam pageParam) {
		
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		
		List<LogDto> logList = logMapper.getLogList(logDto);
		
		PageInfo<LogDto> pageInfo = new PageInfo<LogDto>(logList);
		
		return pageInfo;
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
	public boolean removeLog(Long logId) {
		boolean flag = false;
		int rows = logMapper.delLog(logId);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

}
