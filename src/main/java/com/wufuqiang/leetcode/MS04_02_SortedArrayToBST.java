package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
//最小高度
public class MS04_02_SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		int mid = nums.length/2;
		TreeNode root = new TreeNode(nums[mid]);
		dfs(nums,0,mid-1,root,0);
		dfs(nums,mid+1,nums.length-1,root,1);
		return root;
	}

	public void dfs(int[] nums,int left ,int right,TreeNode root,int direction){
		if(left>right) return;
		int mid = (left+right)/2;
		TreeNode newNode = new TreeNode(nums[mid]);
		if(direction == 0) root.left = newNode;
		else if(direction == 1) root.right = newNode;
		dfs(nums,left,mid-1,newNode,0);
		dfs(nums,mid+1,right,newNode,1);

	}
}
