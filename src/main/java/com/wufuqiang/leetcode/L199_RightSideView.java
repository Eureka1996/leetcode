package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 右视图
 */
public class L199_RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(res,root,0);
		return res;
	}

	public void dfs(List<Integer> res,TreeNode root,int level){
		if(root != null){
			if(res.size() == level){
				res.add(root.val);
			}
			//先右节点
			dfs(res,root.right,level+1);
			//再左节点
			dfs(res,root.left,level+1);

		}
	}
}
