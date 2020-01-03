package com.wufuqiang.leetcode.traversal;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

    //二叉树的先序遍历
    public List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                result.add(root.val);
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    //二叉树的中序遍历
    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
