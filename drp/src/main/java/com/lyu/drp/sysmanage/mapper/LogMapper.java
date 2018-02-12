package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.dto.LogDto;
import com.lyu.drp.sysmanage.entity.Log;

/**
 * 类名称: 日志mapper
 * 类描述: 对日志的一些操作
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.LogMapper
 * @author 曲健磊
 * @date 2018年2月11日 下午7:41:52
 * @version V1.0
 */
public interface LogMapper {
	
	/**
	 * 根据日志的某些已知信息查询日志的完整信息
	 * @param 
	 * @return
	 */
	List<LogDto> getLogList(LogDto logDto);
	
	/**
	 * 添加日志
	 * @param 
	 * @return
	 */
	int saveLog(Log log);
	
	/**
	 * 删除日志
	 * @param 
	 * @return
	 */
	int delLog(Long logId);
	
}
