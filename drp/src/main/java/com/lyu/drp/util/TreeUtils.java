package com.lyu.drp.util;

import java.util.List;

import com.lyu.drp.sysmanage.dto.TreeDto;

/**
 * 类名称: 树工具类
 * 类描述: 对树的一些操作
 * 全限定性类名: com.lyu.drp.util.TreeUtils
 * @author 曲健磊
 * @date 2018年2月1日 下午1:28:05
 * @version V1.0
 */
public class TreeUtils {
	
	/**
	 * 对树形列表进行递归排序
	 * @param <T>
	 * @param returnTreeList	
	 * @param treeList		
	 * @param parentId		
	 */
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
