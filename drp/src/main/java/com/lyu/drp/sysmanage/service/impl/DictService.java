package com.lyu.drp.sysmanage.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyu.drp.common.dto.PageParam;
import com.lyu.drp.sysmanage.entity.Dict;
import com.lyu.drp.sysmanage.mapper.DictMapper;
import com.lyu.drp.sysmanage.service.IDictService;

@Service("dictService")
public class DictService implements IDictService {
	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public List<Dict> getDictList(Dict dict) {
		return dictMapper.getDictList(dict);
	}
	
	@Override
	public PageInfo<Dict> getDictListPage(Dict dict, PageParam pageParam) {
		// 开始分页
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize());
		// 获取所有的数据
		List<Dict> dictList = this.dictMapper.getDictList(dict);
		// 指定条数的字典记录
		PageInfo<Dict> pageInfo = new PageInfo<Dict>(dictList);
		
		return pageInfo;
	}

	@Override
	public List<String> getDictTypeList() {
		return dictMapper.getDictTypeList();
	}

	@Override
	public Dict getDictById(Long dictId) {
		return dictMapper.getDictById(dictId);
	}

	@Override
	public int saveDict(Dict dict) {
		dict.setUpdateBy("1");
		dict.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		return dictMapper.saveDict(dict);
	}

	@Override
	public int updateDict(Dict dict) {
		dict.setParentId("0");
		dict.setUpdateBy("1");
		dict.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		return dictMapper.updateDict(dict);
	}

	@Override
	public int delDictById(Long dictId) {
		return dictMapper.delDictById(dictId);
	}

}
