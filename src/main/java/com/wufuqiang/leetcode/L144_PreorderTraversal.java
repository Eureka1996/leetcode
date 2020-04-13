package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L144_PreorderTraversal {
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
}
