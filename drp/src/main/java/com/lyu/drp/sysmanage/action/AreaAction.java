package com.lyu.drp.sysmanage.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.dto.AreaDto;
import com.lyu.drp.sysmanage.dto.TreeDto;
import com.lyu.drp.sysmanage.entity.Area;
import com.lyu.drp.sysmanage.service.IAreaService;
import com.lyu.drp.util.TreeUtils;

/**
 * 类名称: 区域业务控制类
 * 类描述: 用于管理区域的业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.AreaAction
 * @author 曲健磊
 * @date 2018年2月2日 上午10:02:25
 * @version V1.0
 */
public class AreaAction {
	// 发送给前台的部门列表的json字符串数组
	private String jsonObj;
	// 返回给前台的消息
	private String message;
	// 修改(2)还是增加(1)
	private Integer editFlag;
	// 区域id
	private Long areaId;
	// 区域对象
	private AreaDto area;
	// 查询到的区域列表
	private List<Area> areaList;
	// spring注入
	private IAreaService areaService;
	
	public String getJsonObj() {
		return jsonObj;
	}
	
	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getEditFlag() {
		return editFlag;
	}
	
	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}
	
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public AreaDto getArea() {
		return area;
	}

	public void setArea(AreaDto area) {
		this.area = area;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public IAreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}

	/**
	 * 处理前往区域列表页面的请求
	 * @param 
	 * @return
	 */
	public String gotoAreaList() {
		
		List<Area> tempAreaList = areaService.getAllAreaList();
		List<Area> returnAreaList = new ArrayList<Area>();
		
		TreeUtils.sortTreeList(returnAreaList, tempAreaList, 0L);
		
		this.areaList = returnAreaList;
		
		return "success";
	}
	
	/**
	 * 处理前往区域编辑页面的请求
	 * @param 
	 * @return
	 */
	public String gotoAreaEdit() {
		if (editFlag == 2 && this.areaId != null) { // 修改
			// 调用service查询一下该id的信息
			this.area = this.areaService.getAreaDetailById(this.areaId);
			
		} else if (editFlag == 1 && this.areaId != null) { // 添加下级区域
			this.area = this.areaService.getAreaDetailById(this.areaId);
			Long parentId = this.area.getId();
			String parentName = this.area.getName();
			this.area = null;
			this.area = new AreaDto();
			this.area.setParentId(parentId);
			this.area.setParentName(parentName);
			
		}
		
		return "success";
	}
	
	/**
	 * 保存区域，新增的话editFlag为1，修改为2
	 * @param 
	 * @return
	 */
	public String saveArea() {
		Area area = JSON.parseObject(jsonObj, Area.class);
		
		if (area.getId() == null) { // 新增区域
			boolean flag = areaService.saveArea(area);
			this.message = "no";
			if (flag) {
				this.message = "yes";
			}
		} else { // 修改区域
			boolean flag = areaService.updateArea(area);
			this.message = "no";
			if (flag) {
				this.message = "yes";
			}
		}
		
		return "success";
	}
	
	
	/**
	 * 加载区域zTree
	 * @param 
	 * @return
	 */
	public String getAreaTree() {
		
		List<Area> areaList = areaService.getAllAreaList();
		List<TreeDto> treeList = new ArrayList<TreeDto>();
		
		for (Area area : areaList) {
			TreeDto treeNode = new TreeDto();
			treeNode.setId(area.getId());
			treeNode.setName(area.getName());
			treeNode.setParentId(area.getParentId());
			treeList.add(treeNode);
		}
		
		// 说明是通过单击修改按钮进来的，要剔除掉自己以及它的子孙节点
		if (areaId != null) {
			
			
			
			
		}
		
		
		this.jsonObj = JSONArray.toJSONString(treeList);
		
		return "success";
	}
	
}
