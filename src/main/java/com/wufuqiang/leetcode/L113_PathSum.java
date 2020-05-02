package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;
//路径和为某个值的路径
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
		//不能加此句，因为sum如果为负数，就不正确了
		//if(s>sum) return;
		if(node.left == null && node.right == null){
			if(sum == s){
				List<Integer> newPath = new ArrayList<Integer>(path);
				newPath.add(node.val);
				res.add(newPath);
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
