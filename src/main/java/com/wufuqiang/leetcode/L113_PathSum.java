package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L113_PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(result,path,root,0,sum);

		return result;
	}

	public void backtrack(List<List<Integer>> res,List<Integer> path,TreeNode node,int s,int sum){
		s+=node.val;
		if(node.left == null && node.right == null){
			if(sum == s){
				path.add(node.val);
				res.add(new ArrayList<>(path));
			}
			return;
		}

		path.add(node.val);
		if(node.left != null){
			backtrack(res,path,node.left,s,sum);
		}
		if(node.right != null){
			backtrack(res,path,node.right,s,sum);
		}

		path.remove(path.size()-1);
	}
}
