package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.HashMap;
import java.util.Map;
/**
 * 先序遍历 中序遍历 还原二叉树
 * 重建二叉树
 */

public class L105_BuildTree {
	private int preIndex = 0;
	//前序遍历序列
	private int[] preorder ;
	//中序遍历序列
	private int[] inorder ;
	//中序遍历序列，key为二叉树节点的值，value是索引
	private Map<Integer,Integer> inorderMap = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
        //将中序遍历序列放入到map中，方便后续的使用
		//前序遍历可以知道根节点，根据根节点，中序遍历可以容易的分出左右子树
		for(int i = 0;i<inorder.length;i++){
			this.inorderMap.put(inorder[i],i);
		}
		return dfs(0,inorder.length-1);
	}

	public TreeNode dfs(int inLeft,int inRight){
		if(inLeft>inRight) return null;
		//通过前序遍历，找到根节点的值
		int rootValue = this.preorder[preIndex];
		//生成对应的节点
		TreeNode root = new TreeNode(rootValue);

		//前序遍历节点前移
		this.preIndex+=1;

		//找到中间节点
		int midIndex = this.inorderMap.get(rootValue);
		root.left = dfs(inLeft,midIndex-1);
		root.right = dfs(midIndex+1,inRight);
		return root;
	}
}
