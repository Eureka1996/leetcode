package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L1339_MaxProduct {

	private double sum = 0;
	private double best = 0;
	public int maxProduct(TreeNode root) {
		getSum(root);
		cutEdge(root);
		best = (best%(1E9+7)) * (sum-best)%(1E9+7) % (1E9+7);
		return (int)best;

	}

	public void getSum(TreeNode root){
		if(root == null){
			return ;
		}
		sum+=root.val;
		getSum(root.left);
		getSum(root.right);
	}

	public double cutEdge(TreeNode root){
		if(root == null){
			return 0;
		}
		double cur = cutEdge(root.left) + cutEdge(root.right) + root.val;
		if(Math.abs(cur-sum/2) < Math.abs(best-sum/2)){
			best = cur;
		}
		return cur;
	}
}
