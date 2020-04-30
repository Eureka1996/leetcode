package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//两棵树，判断是否为子树
public class MS04_10_CheckSubTree {
	public boolean checkSubTree(TreeNode t1, TreeNode t2) {
		if(t1 == null){
			return t2 == null;
		}
		return isSame(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);

	}

	public boolean isSame(TreeNode t1,TreeNode t2){
		if(t1 ==null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		return t1.val == t2.val && isSame(t1.left,t2.left) && isSame(t1.right,t2.right);
	}
}
