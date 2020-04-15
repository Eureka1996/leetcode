package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root==null){
			return result;
		}
		recustion(result,"",root);
		return result;
	}

	public void recustion(List<String> res,String path,TreeNode node){
		if(path == ""){
			path = path + node.val;
		}{
			path = path + "->" + node.val;
		}

		if(node.left == null && node.right == null){
			res.add(path);
		}else{
			if(node.left != null){
				recustion(res,path,node.left);
			}
			if(node.right != null){
				recustion(res,path,node.right);
			}
		}
	}
}
