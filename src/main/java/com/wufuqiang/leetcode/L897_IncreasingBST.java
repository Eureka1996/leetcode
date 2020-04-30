package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.LinkedList;
//中序遍历转链表
public class L897_IncreasingBST {
	public TreeNode increasingBST(TreeNode root) {

		TreeNode result = new TreeNode(0);
		TreeNode tmpResult = result;

		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmp = root;
		while(tmp != null || !stack.isEmpty()){

			if(tmp != null){
				while(tmp != null ){
					stack.offerFirst(tmp);
					tmp = tmp.left;
				}
			}else{
				TreeNode node = stack.pollFirst();
				node.left = null;
				tmpResult.right = node;
				tmpResult = tmpResult.right;
				tmp = node.right;
			}

		}


		return result.right;
	}
}
