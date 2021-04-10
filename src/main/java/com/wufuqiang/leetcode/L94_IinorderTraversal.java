package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代，中序遍历，左-根-右
 */
public class L94_IinorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmp = root;
		while(tmp != null || !stack.isEmpty()){

			while(tmp != null){
				stack.offerFirst(tmp);
				tmp = tmp.left;
			}
			tmp = stack.pollFirst();
			result.add(tmp.val);
			tmp = tmp.right;
		}
		return result;
	}


	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<>();
		inorder(root,result);
		return result;
	}

	public void inorder(TreeNode root ,List<Integer> result){
		if(root == null) return ;
		inorder(root.left,result);
		result.add(root.val);
		inorder(root.right,result);
	}
}
