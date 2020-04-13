package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代，中序遍历
 */
public class L94_IinorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmp = root;
		while(tmp != null || !stack.isEmpty()){
			if(tmp != null){
				while(tmp != null){
					stack.offerFirst(tmp);
					tmp = tmp.left;
				}
			}else{
				tmp = stack.pollFirst();
				result.add(tmp.val);
				tmp = tmp.right;
			}
		}
		return result;
	}
}
