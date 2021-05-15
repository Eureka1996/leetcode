package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的之字形层序遍历
 * 二叉树的锯齿形层次遍历
 */
public class L103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;

        List<Integer> tmp = new ArrayList<Integer>();

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int num = 0;
        int count = 1;
        // 约定: flag==true表示当前层是奇数层; flag==false表示当前层是偶数层; root是奇数层
        boolean flag = true;
        TreeNode current ;

        while(!queue.isEmpty()){

            if(flag){
                current = queue.pollFirst();
                tmp.add(current.val);

                if(current.left != null){
                    queue.addLast(current.left);
                    num+=1;
                }
                if(current.right != null){
                    queue.addLast(current.right);
                    num+=1;
                }
            }else{
                current = queue.pollLast();
                tmp.add(current.val);
                if(current.right != null){
                    queue.addFirst(current.right);
                    num+=1;
                }
                if(current.left != null){
                    queue.addFirst(current.left);
                    num+=1;
                }


            }
            count--;
            if(count == 0){
                count = num;
                num = 0;
                flag = !flag;
                result.add(tmp);
                tmp = new ArrayList<Integer>();

            }

        }
        return result;
    }


    public List<List<Integer>> zigzagLevelOrder01(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        boolean isLeft = true;
        q.offerFirst(root);
        while(!q.isEmpty()){
            int levelLen = q.size();
            TreeNode tmp = null;
            List<Integer> resTmp = new ArrayList<>();
            while(levelLen > 0){
                if(isLeft){
                    tmp = q.pollFirst();
                    resTmp.add(tmp.val);
                    if(tmp.left != null){
                        q.offerLast(tmp.left);
                    }
                    if(tmp.right != null){
                        q.offerLast(tmp.right);
                    }
                }else{
                    tmp = q.pollLast();
                    resTmp.add(tmp.val);
                    if(tmp.right != null){
                        q.offerFirst(tmp.right);
                    }
                    if(tmp.left != null){
                        q.offerFirst(tmp.left);
                    }

                }

                levelLen--;
            }
            res.add(resTmp);
            isLeft =  !isLeft;
        }
        return res;
    }



}
