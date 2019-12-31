package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L404_SumOfLeftLeaves {
    private int sum =0;
    private void leftLeavesRec(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left != null){
            TreeNode left = root.left;
            if(left.left == null && left.right == null){
                sum+=left.val;
            }else{
                leftLeavesRec(left);
            }
        }
        leftLeavesRec(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        leftLeavesRec(root);
        return sum;
    }
}
