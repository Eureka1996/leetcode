package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L513_FindBottomLeftValue {
	private int maxLevel = -1;
	private int result = 0;
	public int findBottomLeftValue(TreeNode root) {
		dfs(root,0);
		return result;
	}

	public void dfs(TreeNode root,int level){
		if(root == null) return;
		if(maxLevel<level){
			maxLevel=level;
			result = root.val;
		}

		result = root.val;
		dfs(root.right,level+1);
		dfs(root.left,level+1);
	}
}
