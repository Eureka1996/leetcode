package com.wufuqiang.company.meituan;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.List;

public class Similar2020042305 {
	public static void main(String[] args) {
		System.out.println(3&4);
	}

	public void rightSideView(TreeNode root, List<Integer> result,int level){
		if(root == null) return;
		if(result.size()<=level){
			result.add(root.val);
		}
		rightSideView(root.left,result,level);
		rightSideView(root.right,result,level);

	}
}
