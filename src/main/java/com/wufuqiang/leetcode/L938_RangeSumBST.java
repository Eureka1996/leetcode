package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//二叉搜索树的范围和 给定值范围的和
public class L938_RangeSumBST {
	int sum = 0;
	public int rangeSumBST(TreeNode root, int L, int R) {
		rangeSumBSTRec(root,L,R);
		return sum;
	}

	public void rangeSumBSTRec(TreeNode root , int L , int R){
		if(root == null) return;
		if(root.val >= L && root.val <= R) {
			sum+=root.val;
			rangeSumBSTRec(root.left,L,R);
			rangeSumBSTRec(root.right,L,R);
		}else if(root.val < L){
			rangeSumBSTRec(root.right,L,R);
		}else if(root.val > R){
			rangeSumBSTRec(root.left,L,R);
		}
	}


}
