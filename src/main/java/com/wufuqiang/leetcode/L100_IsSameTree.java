package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * 相同的树
 * 相同的二叉树
 */
public class L100_IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}else if(p != null && q != null && p.val == q.val){
			return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}else{
			return false;
		}
	}
}
