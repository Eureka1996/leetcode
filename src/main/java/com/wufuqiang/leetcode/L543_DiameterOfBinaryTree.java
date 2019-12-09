package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 20:00
 **/
public class L543_DiameterOfBinaryTree {
    int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans -1;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans,left+right+1);
        return Math.max(left,right)+1;
    }
}
