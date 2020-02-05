package com.wufuqiang.test;

import com.wufuqiang.leetcode.entries.TreeNode;
import com.wufuqiang.leetcode.traversal.BinaryTreeTraversal;
import com.wufuqiang.leetcode.tree.BST;
import org.junit.Test;

/**
 * @ author wufuqiang
 **/
public class BSTTest {
    BinaryTreeTraversal travel = new BinaryTreeTraversal();

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        BST.insert(root,new TreeNode(12));
        BST.insert(root,new TreeNode(1));
        System.out.println(travel.inOrder(root));
        TreeNode searched = BST.search(root,129);
        System.out.println(searched);
    }

    @Test
    public void removeTest(){
        TreeNode root = new TreeNode(15);
        BST.insert(root,new TreeNode(6));
        BST.insert(root,new TreeNode(18));
        BST.insert(root,new TreeNode(3));
        BST.insert(root,new TreeNode(7));
        BST.insert(root,new TreeNode(17));
        BST.insert(root,new TreeNode(20));
        BST.insert(root,new TreeNode(2));
        BST.insert(root,new TreeNode(4));
        BST.insert(root,new TreeNode(13));
        BST.insert(root,new TreeNode(9));
        System.out.println(travel.inOrder(root));
        TreeNode searched = BST.search(root, 13);
        System.out.println(searched);
        TreeNode successor = BST.successor(searched);
        System.out.println(successor);

    }
}
