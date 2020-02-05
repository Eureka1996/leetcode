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
}
