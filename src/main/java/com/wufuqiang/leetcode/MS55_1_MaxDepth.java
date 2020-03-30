package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class MS55_1_MaxDepth {
	public int maxDepth(TreeNode root) {
		int left = 1;
		int right = 1;
		if(root == null){
			return 0;
		}else{
			left+=maxDepth(root.left);
			right+=maxDepth(root.right);
		}
		return Math.max(left,right);
	}
}
