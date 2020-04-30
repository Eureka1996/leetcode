package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.LinkedList;
//合法二叉搜索树
public class MS04_05_IsValidBST {
	public boolean isValidBST(TreeNode root) {
		long lastValue = Integer.MIN_VALUE-1l;
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode tmp = root;
		boolean flag = true;
		while (tmp != null || !stack.isEmpty()){
			if(tmp != null){
				while(tmp != null){
					stack.offerFirst(tmp);
					tmp = tmp.left;
				}
			}else{
				tmp = stack.pollFirst();
				if(!(lastValue<tmp.val)){
					flag = false;
					break;
				}
				lastValue = tmp.val;
				tmp = tmp.right;
			}
		}
		return flag;
	}
}
