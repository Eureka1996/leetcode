package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//判断二叉树是否平衡
public class MS04_04_IsBalanced {
	public boolean isBalanced(TreeNode root) {
		int depth = depth(root);
		return depth == -1?false:true;

	}
	public int depth(TreeNode root){
		if(root == null) return 0;
		int left = depth(root.left);
		if(left == -1) return -1;
		int right = depth(root.right);
		if(right == -1) return -1;
		return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
	}
}
