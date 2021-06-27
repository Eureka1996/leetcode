package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//二叉对的深度、高度
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

	public int maxDepth2(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftDepth = maxDepth2(root.left);
		int rightDepth = maxDepth2(root.right);
		if(leftDepth>rightDepth){
			return leftDepth+1;
		}else{
			return rightDepth+1;
		}
	}
}
