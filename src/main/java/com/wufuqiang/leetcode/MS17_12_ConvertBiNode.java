package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.LinkedList;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-15 11:09
 */
public class MS17_12_ConvertBiNode {
    public static void main(String[] args) {

    }

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode prev = result;
        if(root == null) return root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode tmp = root;
        while(tmp != null || !stack.isEmpty()){
            while(tmp != null){
                stack.offerFirst(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pollFirst();
            prev.right = tmp;
            prev = prev.right;
            tmp.left = null;
            tmp = tmp.right;
        }
        return result.right;
    }


}
