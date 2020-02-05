package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.TreeNode;

/**
 * @ author wufuqiang
 **/
public class BST {
    public static TreeNode search(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }else if(val < root.val){
            return search(root.left,val);
        }else {
            return search(root.right,val);
        }
    }

    public static TreeNode insert(TreeNode root,TreeNode node){
        if(root==null){
            return node;
        }
        if(node.val <= root.val){
            if(root.left == null){
                root.left = node;
            }else{
                insert(root.left,node);
            }
        }else{
            if(root.right == null){
                root.right = node;
            }else{
                insert(root.right,node);
            }
        }
        return root;
    }

    public static TreeNode min(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static TreeNode max(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public static TreeNode successor(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.right != null){
            return min(root.right);
        }
        TreeNode tmp = root.parent;
        while(tmp != null && tmp.right == root){
            root = tmp;
            tmp = tmp.parent;
        }
        return tmp;
    }

}
