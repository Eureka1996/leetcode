package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L114_Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        TreeNode rootTmp = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root !=  null){
                tmp.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        boolean isFirstEle = true;
        TreeNode preNode = root;
        for(TreeNode node : tmp){
            if(!isFirstEle){
                preNode.left = null;
                preNode.right = node;
                preNode = node;
            }else{
                preNode = node;
                isFirstEle = false;
            }
        }
    }
}
