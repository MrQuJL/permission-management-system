package com.lyu.pms.common.dto;

/**
 * 类名称: 分页对象
 * 类描述: 页面传输过来的分页对象
 * 全限定性类名: com.lyu.drp.common.dto.PageParam
 * @author 曲健磊
 * @date 2018年1月22日 上午10:26:10
 * @version V1.0
 */
public class PageParam {
	// 第几页，默认第一页
	private Integer pageNo = 1;
	// 每页多少条，默认10条
	private Integer pageSize = 10;
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
