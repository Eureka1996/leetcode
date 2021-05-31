package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代，前序遍历，根左右
 */
public class L144_PreorderTraversal {
	//迭代前序遍历
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmpRoot = root;
		while(tmpRoot != null || !stack.isEmpty()){
			if(tmpRoot != null){
				result.add(tmpRoot.val);
				stack.offerFirst(tmpRoot);
				tmpRoot=tmpRoot.left;
			}else{
				tmpRoot = stack.pollFirst();
				tmpRoot=tmpRoot.right;
			}
		}

		return result;
	}

	//递归前序遍历
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<>();

		preorder(root,result);

		return result;
	}

	public void preorder(TreeNode root ,List<Integer> result){
		if(root == null) return;
		result.add(root.val);
		preorder(root.left,result);
		preorder(root.right,result);
	}

}
