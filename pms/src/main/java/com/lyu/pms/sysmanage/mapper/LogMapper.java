package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.dto.LogDto;
import com.lyu.pms.sysmanage.entity.Log;

/**
 * 类名称: 日志mapper
 * 类描述: 对日志的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.LogMapper
 * @author 曲健磊
 * @date 2018年2月11日 下午7:41:52
 * @version V1.0
 */
public interface LogMapper {
	
	/**
	 * 根据日志的某些已知信息查询日志的完整信息
	 * @param logDto 根据该对象所拥有的条件查询日志列表
	 * @return 满足条件的查询列表
	 */
	List<LogDto> getLogList(LogDto logDto);
	
	/**
	 * 添加日志
	 * @param log 要添加的日志
	 * @return 受影响的行数，1表示添加成功，否则失败
	 */
	int saveLog(Log log);
	
	/**
	 * 删除日志
	 * @param logId 要删除的日志id
	 * @return 受影响的行数，1表示删除成功，否则失败
	 */
	int delLog(Long logId);
	
}
