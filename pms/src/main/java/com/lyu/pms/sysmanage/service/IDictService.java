package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.entity.Dict;

/**
 * 类名称: 字典业务处理接口
 * 类描述: 用于提供对字典的一些服务
 * 全限定性类名: com.lyu.pms.sysmanage.service.IDictService
 * @author 曲健磊
 * @date 2018年1月19日 下午8:16:16
 * @version V1.0
 */
public interface IDictService {
	
	/**
	 * 查询字典列表
	 * @param dict 已知的字典信息
	 * @return 满足dict中已有条件的字典列表
	 */
	List<Dict> getDictList(Dict dict);
	
	/**
	 * 分页查询字典列表
	 * @param dict 已知的字典信息
	 * @param pageParam 分页对象，包含当前的页数和每页的大小
	 * @return 经过分页的字典列表
	 */
	PageInfo<Dict> getDictListPage(Dict dict, PageParam pageParam);
	
	/**
	 * 获取所有的字典类型
	 * @return 所有的字典类型列表
	 */
	List<String> getDictTypeList();
	
	/**
	 * 获取指定id的字典
	 * @param dictId 字典的id
	 * @return id为dictId的字典
	 */
	Dict getDictById(Long dictId);
	
	/**
	 * 新增字典
	 * @param dict 待新增的字典
	 * @return 新增字典成功的记录数
	 */
	int saveDict(Dict dict);
	
	/**
	 * 修改字典
	 * @param dict 待修改的字典
	 * @return 修改字典成功的记录数
	 */
	int updateDict(Dict dict);
	
	/**
	 * 根据字典id删除字典
	 * @param dictId 待删除的字典id
	 * @return  删除字典成功的记录数
	 */
	int delDictById(Long dictId);
	
}
