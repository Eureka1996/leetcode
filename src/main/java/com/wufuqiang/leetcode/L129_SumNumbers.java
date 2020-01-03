package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L129_SumNumbers {
    private int sum = 0;
    public void leafNum(TreeNode root,int parentNum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum += (parentNum*10+root.val);
        }
        if(root.left != null){
            leafNum(root.left,parentNum*10+root.val);
        }
        if(root.right != null){
            leafNum(root.right,parentNum*10+root.val);
        }
    }
    public int sumNumbers(TreeNode root) {
        leafNum(root,0);
        return sum;
    }
}
