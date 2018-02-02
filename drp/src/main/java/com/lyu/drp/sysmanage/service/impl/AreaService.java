package com.lyu.drp.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.AreaDto;
import com.lyu.drp.sysmanage.entity.Area;
import com.lyu.drp.sysmanage.mapper.AreaMapper;
import com.lyu.drp.sysmanage.service.IAreaService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 区域服务接口的实现类
 * 类描述: 对区域服务接口的具体实现
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.AreaService
 * @author 曲健磊
 * @date 2018年2月2日 上午10:25:56
 * @version V1.0
 */
@Service("areaService")
public class AreaService implements IAreaService {

	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public AreaDto getAreaDetailById(Long id) {
		return areaMapper.getAreaDetailById(id);
	}
	
	@Override
	public List<Area> getAllAreaList() {
		return areaMapper.getAllAreaList();
	}

	@Override
	public boolean saveArea(Area area) {
		boolean flag = false;
		
		if (area.getParentId() == null) { // 没有选择父部门则为顶级部门
			area.setParentId(0L);
		}
		
		area.setCreateBy(UserUtils.getCurrentUserId());
		area.setCreateDate(new Date());
		area.setUpdateBy(UserUtils.getCurrentUserId());
		area.setUpdateDate(new Date());
		
		int rows = areaMapper.saveArea(area);
		
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateArea(Area area) {
		boolean flag = false;
		
		if (area.getParentId() == null) { // 没有选择父部门则为顶级部门
			area.setParentId(0L);
		}
		
		area.setUpdateBy(UserUtils.getCurrentUserId());
		area.setUpdateDate(new Date());
		
		int rows = areaMapper.updateArea(area);
		
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}

}
