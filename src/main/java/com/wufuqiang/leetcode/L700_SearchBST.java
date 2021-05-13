package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-13 10:18
 */
public class L700_SearchBST {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = null;
        while(root != null){
            if(root.val == val){
                result = root;
                break;
            }else if(root.val < val){
                root = root.right;
            }else{
                root = root.left;
            }
        }

        return result;
    }

}
