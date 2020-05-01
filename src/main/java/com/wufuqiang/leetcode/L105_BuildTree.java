package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.HashMap;
import java.util.Map;
//先序遍历 中序遍历 还原二叉树
public class L105_BuildTree {
	private int preIndex = 0;
	private int[] preorder ;
	private int[] inorder ;
	private Map<Integer,Integer> inorderMap = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;

		for(int i = 0;i<inorder.length;i++){
			this.inorderMap.put(inorder[i],i);
		}
		return dfs(0,inorder.length-1);
	}

	public TreeNode dfs(int inLeft,int inRight){
		if(inLeft>inRight) return null;
		int rootValue = this.preorder[preIndex];
		TreeNode root = new TreeNode(rootValue);
		this.preIndex+=1;
		int midIndex = this.inorderMap.get(rootValue);
		root.left = dfs(inLeft,midIndex-1);
		root.right = dfs(midIndex+1,inRight);
		return root;
	}
}
