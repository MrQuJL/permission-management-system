package com.lyu.pms.util;

import java.util.List;

import com.lyu.pms.sysmanage.entity.Dept;

/**
 * 类名称: 部门工具类
 * 类描述: 封装了一些部门工具
 * 全限定性类名: com.lyu.pms.util.DeptUtils
 * @author 曲健磊
 * @date 2018年1月31日 下午3:15:33
 * @version V1.0
 */
public class DeptUtils {
	
	/**
	 * 对部门列表进行递归排序	
	 * @param returnDepts 排序后的部门列表，外部手动传入
	 * @param deptList 排序前的部门列表
	 * @param parentId 顶级部门的id
	 * @deprecated 方法已经过时，请使用com.lyu.pms.util.TreeUtils.sortTreeList
	 */
	@Deprecated
	public static void sortDeptList(List<Dept> returnDepts, List<Dept> deptList, Long parentId) {
		// 轮询所有的菜单
		for (int i = 0; i < deptList.size(); i++) {
			Dept dept = deptList.get(i);
			// 找到第一级菜单
			if (dept.getParentId() != null && dept.getParentId().equals(parentId)) {
				returnDepts.add(dept);
				for (Dept child : deptList) {
					// 递归
					if (child.getParentId() != null && child.getParentId().equals(parentId)) {
						sortDeptList(returnDepts, deptList, dept.getId());
						break;
					}
				}
			}
		}
	}
}
