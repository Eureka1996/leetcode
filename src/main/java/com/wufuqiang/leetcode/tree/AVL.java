package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.AVLNode;

/**
 * @ author wufuqiang
 **/
public class AVL {
    /**
     * 左左单旋
     * @param node
     * @return
     */
    private AVLNode<Integer> singleRotateLeft(AVLNode<Integer> node){
        AVLNode<Integer> left = node.left;
        AVLNode<Integer> leftRight = left.right;
        node.left = leftRight;
        left.right = node;
        node.height = Math.max(node.left.height,node.right.height)+1;
        left.height = Math.max(left.left.height,left.right.height)+1;
        return left;
    }

    /**
     * 右右单旋
     * @param node
     * @return
     */
    private AVLNode<Integer> singleRotateRight(AVLNode<Integer> node){
        AVLNode<Integer> right = node.right;
        node.right = right.left;
        right.left = right;
        node.height = Math.max(node.left.height,node.right.height)+1;
        right.height = Math.max(right.left.height,right.right.height)+1;
        return right;
    }




}
