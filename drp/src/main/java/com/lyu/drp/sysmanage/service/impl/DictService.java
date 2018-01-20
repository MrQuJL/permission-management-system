package com.lyu.drp.sysmanage.service.impl;

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
    
}
