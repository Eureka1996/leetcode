package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//祖父节点为偶数
public class L1315_SumEvenGrandparent {
	int result = 0;
	public int sumEvenGrandparent(TreeNode root) {
		dfs(null,null,root);

		return result;
	}

	public void dfs(TreeNode grandparent,TreeNode parent,TreeNode current){
		if(current != null){
			if(grandparent != null && grandparent.val % 2 == 0) result+=current.val;
			if(current.left != null) dfs(parent,current,current.left);
			if(current.right != null) dfs(parent,current,current.right);
		}
	}
}
