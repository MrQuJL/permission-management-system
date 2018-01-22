package com.lyu.drp.sysmanage.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lyu.drp.sysmanage.entity.Dict;
import com.lyu.drp.sysmanage.service.IDictService;

/**
 * 类名称: 字典管理业务控制类
 * 类描述: 对字典的一些增删改查
 * 全限定性类名: com.lyu.drp.sysmanage.action.DictAction
 * @author 曲健磊
 * @date 2018年1月19日 下午7:52:22
 * @version V1.0
 */
public class DictAction {
	// 发送给前台的字典列表的json字符串数组
	private String jsonObj;
	// 字典的类型
	private String type;
	// 字典的描述
	private String description;
	// 整合包会负责注入
	private IDictService dictService;
	// 判断是添加字典还是修改字典的标记位
	private Long dictId;
	// 返回给前台的消息
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IDictService getDictService() {
		return dictService;
	}

	public void setDictService(IDictService dictService) {
		this.dictService = dictService;
	}

	/**
	 * 进入字典列表页面
	 * @param 
	 * @return
	 */
	public String gotoDictList() {
		// 1.加载所有的字典类型
		List<String> dictTypeList = dictService.getDictTypeList();
		
		// 2.放入session里面
		ServletActionContext.getRequest().getSession().setAttribute("dictTypeList", dictTypeList);
		
		return "dictList";
	}
	
	/**
	 * 获取字典列表
	 * @param 
	 * @return
	 */
	public String getDictList() {
		if (StringUtils.isEmpty(type)) {
			type = null;
		}
		if (StringUtils.isEmpty(description)) {
			description = null;
		}
		
		Dict dict = new Dict();
		dict.setType(type);
		dict.setDescription(description);
		
		List<Dict> dictList = dictService.getDictList(dict);
		
		this.jsonObj =  JSONArray.toJSONString(dictList);
		
		return "success";
	}
	
	/**
	 * 获取分页的字典列表
	 * @param 
	 * @return
	 */
	public String getDictListPage() {
		
		
		
		return "success";
	}
	
	/**
	 * 进入字典编辑页面
	 * @param 
	 * @return
	 */
	public String gotoDictEdit() {
		if (dictId != null) { // 修改，将该id的字典信息查询出来放到session里面
			Dict dict = dictService.getDictById(dictId);
			ServletActionContext.getRequest().getSession().setAttribute("dict", dict);
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("dict", null);
		}
		
		return "dictEdit";
	}
	
	/**
	 * 保存字典
	 * @param 
	 * @return
	 */
	public String saveDict() {
		// 将前台传来的json字符串解析成Dict对象
		Dict dict = JSON.parseObject(jsonObj, Dict.class);
		System.out.println(dict);
		if (dict.getId() != null) { // 修改字典
			int rows = dictService.updateDict(dict);
			this.message = "修改字典失败";
			if (rows > 0) {
				this.message = "修改字典成功";
			}
		} else { // 新增字典
			int rows = dictService.saveDict(dict);
			this.message = "新增字典失败";
			if (rows > 0) {
				this.message = "新增字典成功";
			}
		}
		return "success";
	}
	
	/**
	 * 删除字典(逻辑删除)
	 * @param 
	 * @return
	 */
	public String delDict() {
		int rows = dictService.delDictById(dictId);
		this.message = "删除字典失败";
		if (rows > 0) {
			this.message = "删除字典成功";
		}
		
		return "success";
	}
	
}
