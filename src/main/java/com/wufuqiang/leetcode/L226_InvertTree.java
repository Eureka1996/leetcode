package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

public class L226_InvertTree {
    class Solution {

        private void invertRec(TreeNode root){
            if(root == null) return ;
            TreeNode tmp = root.left ;
            root.left = root.right;
            root.right = tmp;
            invertRec(root.left);
            invertRec(root.right);
        }

        public TreeNode invertTree(TreeNode root) {
            invertRec(root);
            return root;
        }
    }
}
