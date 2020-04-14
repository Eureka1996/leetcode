package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;
// 平衡二叉树
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
//
//
//
// 限制：
//
//
// 1 <= 树的结点个数 <= 10000
//
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
//
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
public class MS55_2_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int d = depth(root);
        return d == -1 ? false:true;
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == -1 || rightDepth == -1){
            return -1;
        }
        if(Math.abs(leftDepth-rightDepth) > 1){
            return -1;
        }else{
            return Math.max(leftDepth,rightDepth)+1;
        }
    }
}
