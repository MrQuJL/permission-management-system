package com.lyu.pms.sysmanage.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 类名称: 自定义标签业务控制类
 * 类描述: 处理zTree格式的菜单请求
 * 全限定性类名: com.lyu.pms.sysmanage.action.TagAction
 * @author 曲健磊
 * @date 2018年1月28日 上午9:12:04
 * @version V1.0
 */
public class TagAction extends ActionSupport{

	private static final long serialVersionUID = -6477088024495814852L;
	
	private String url;
	
	private String checked;
	
	private String selectIds;
	
	private String value;
	
    /**
     * 跳转到icon页面
     * @param null
	 * @return 视图名称
     */
    public String iconSelect(){
    	return "iconSelect";
    }
    
	public String getUrl() {
		return url;
	}

	/**
	 * 一系列的setter和getter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getSelectIds() {
		return selectIds;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
