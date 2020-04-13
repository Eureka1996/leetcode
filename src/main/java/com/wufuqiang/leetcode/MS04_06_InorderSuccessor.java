package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历的后继者
 */
public class MS04_06_InorderSuccessor {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode result = null;

		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmp = root;
		boolean flag = false;
		while(tmp != null || !stack.isEmpty()){
			if(tmp != null){
				while(tmp != null){
					stack.offerFirst(tmp);
					tmp = tmp.left;
				}
			}else{
				tmp = stack.pollFirst();
				if(flag){
					result = tmp;
					break;
				}
				if(tmp == p){
					flag = true;
				}
				tmp = tmp.right;
			}
		}

		return result;
	}
}
