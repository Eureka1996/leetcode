package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L783_MinDiffInBST {
    public void inOrder(TreeNode root){

    }
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        boolean isFirstElement = true;
        int preEle = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root =root.left;
            }
            root = stack.pop();
            if(isFirstElement){
                preEle = root.val;
            }else{
                if(root.val - preEle < result){
                    result = root.val-preEle;
                }
                preEle = root.val;
            }
            root = root.right;
        }
        return result;
    }
}
