package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//分配金币 硬币 转移
public class L979_DistributeCoins {
	private int ans = 0;
	public int distributeCoins(TreeNode root) {
		ans=0;
		dfs(root);
		return ans;
	}

	public int dfs(TreeNode root){
		if(root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		ans+=(Math.abs(left)+Math.abs(right));
		return root.val+left+right-1;
	}
}
