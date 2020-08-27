package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * 二叉树的最大深度
 */
public class L104_MaxDepth {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth,rightDepth)+1;
	}
}
