package com.lyu.pms.util;

import java.util.List;

import com.lyu.pms.sysmanage.dto.TreeDto;

/**
 * 类名称: 树工具类
 * 类描述: 对树的一些操作
 * 全限定性类名: com.lyu.pms.util.TreeUtils
 * @author 曲健磊
 * @date 2018年2月1日 下午1:28:05
 * @version V1.0
 */
public class TreeUtils {
	
	/**
	 * 对树形列表进行递归排序
	 * @param <T> 排序的元素类型
	 * @param returnTreeList 返回的排序之后的树列表
	 * @param treeList	排序前的树列表
	 * @param parentId	父节点id
	 */
	@SuppressWarnings("unchecked")
	public static <T> void sortTreeList(List<T> returnTreeList, List<T> treeList,
		Long parentId) {
		// 轮询所有的菜单
		for (int i = 0; i < treeList.size(); i++) {
			TreeDto tree = (TreeDto) treeList.get(i);
			// 找到第一级菜单
			if (tree.getParentId() != null && tree.getParentId().equals(parentId)) {
				returnTreeList.add((T) tree);
				for (T child : treeList) {
					// 递归
					if (((TreeDto) child).getParentId() != null && ((TreeDto) child).getParentId().equals(parentId)) {
						sortTreeList(returnTreeList, treeList, tree.getId());
						break;
					}
				}
			}
		}
	}
}
