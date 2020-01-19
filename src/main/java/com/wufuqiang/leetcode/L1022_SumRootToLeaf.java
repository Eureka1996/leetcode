package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L1022_SumRootToLeaf {

    private int sum = 0;

    public void sumRootToLeafRec(TreeNode root,int num){
        if(root==null){
            return ;
        }
        if(root.left == null && root.right == null){
            sum += (num*2+root.val);
        }
        if(root.left != null){
            sumRootToLeafRec(root.left,num*2+ root.val);
        }
        if(root.right != null){
            sumRootToLeafRec(root.right,num*2+root.val);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafRec(root,0);
        return this.sum;
    }
}
