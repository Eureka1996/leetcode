package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.HashMap;
import java.util.Map;
//中序遍历 后序遍历 还原二叉树
public class L106_BuildTree {
	//后序遍历的位置
	private int postIndex = 0;
	private int[] inorder;
	private int[] postorder;
	private Map<Integer,Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		//
		for(int i = 0;i<inorder.length;i++){
			map.put(inorder[i],i);
		}
		//指定后序遍历最开始时的位置为最后一个
		this.postIndex = postorder.length;
		return dfs(0,postorder.length);
	}

	public TreeNode dfs(int inLeft,int inRight){
		if(inLeft>inRight) return null;
		int rootVal = this.postorder[this.postIndex];
		TreeNode root = new TreeNode(rootVal);
        this.postIndex-=1;
		int inIndex = this.map.get(rootVal);
		root.right = dfs(inIndex+1,inRight);
		root.left = dfs(inLeft,inIndex-1);
		return root;
	}
}
