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
	 * 获得字典列表
	 * @param type 字典的类型
	 * @param description 字典的描述
	 * @return 字典列表
	 */
	List<Dict> getDictList(Dict dict);
	
	/**
	 * 获取分页的字典列表
	 * @param 
	 * @return
	 */
	PageInfo<Dict> getDictListPage(Dict dict, PageParam pageParam);
	
	/**
	 * 获取所有的字典类型
	 * @param 
	 * @return
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
	 * @param 
	 * @return
	 */
	int saveDict(Dict dict);
	
	/**
	 * 修改字典
	 * @param 
	 * @return
	 */
	int updateDict(Dict dict);
	
	/**
	 * 根据字典id删除字典
	 * @param 
	 * @return
	 */
	int delDictById(Long dictId);
	
}