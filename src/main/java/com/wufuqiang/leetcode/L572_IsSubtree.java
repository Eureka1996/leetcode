package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//另一个树的子树
public class L572_IsSubtree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null && t == null){
			return true;
		} else if(s != null && t != null){
			boolean issame = false;
			if(s.val == t.val){
				issame = isSameTree(s,t);
			}
			return issame || isSubtree(s.left,t) || isSubtree(s.right,t);
		} else if(s != null && t == null){
			return true;
		}else{
			return false;
		}
	}

	public boolean isSameTree(TreeNode t1,TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val != t2.val) return false;
		else return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right);
	}
}
