package com.lyu.drp.sysmanage.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
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
