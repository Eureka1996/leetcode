package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//层次遍历
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回：
//
// [3,9,20,15,7]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索

public class MS32_1_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return new int[]{};
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.pollFirst();
            result.add(tmp.val);
            if(tmp.left!=null){
                queue.offerLast(tmp.left);
            }
            if(tmp.right!=null){
                queue.offerLast(tmp.right);
            }
        }
        int[] r = new int[result.size()];
        for(int i = 0; i<result.size();i++){
            r[i] = result.get(i);
        }
        return r;
    }
}
