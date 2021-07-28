package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-28 22:01
 */
public class L863_DistanceK {
    public static void main(String[] args) {

    }
    private Map<Integer,TreeNode> parent = new HashMap<>();
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        findAns(target,null,0,k);
        return ans;
    }

    private void findParent(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val,root);
            findParent(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            findParent(root.right);
        }
    }

    private void findAns(TreeNode node,TreeNode from,int depth,int k){
        if(node == null) return;
        if(depth == k) {
            ans.add(node.val);
            return;
        }
        if(node.left != from){
            findAns(node.left,node,depth+1,k);
        }
        if(node.right != from){
            findAns(node.right,node,depth+1,k);
        }
        if(parent.get(node.val) != from){
            findAns(parent.get(node.val),node,depth+1,k);
        }
    }
}
