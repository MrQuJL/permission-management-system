package com.lyu.drp.sysmanage.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.entity.Dict;
import com.lyu.drp.sysmanage.mapper.DictMapper;
import com.lyu.drp.sysmanage.service.IDictService;

@Service("dictService")
public class DictService implements IDictService {
	@Autowired
	private DictMapper dictMapper;
	
	@Override
	public List<Dict> getDictList(String type, String description) {
		return dictMapper.getDictList(type, description);
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
