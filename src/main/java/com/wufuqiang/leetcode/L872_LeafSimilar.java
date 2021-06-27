package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L872_LeafSimilar {
    public void getLeaf(TreeNode root, List<Integer> leftVal){
        if(root == null || leftVal == null){
            return ;
        }
        if(root.left == null && root.right == null){
            leftVal.add(root.val);
        }
        if(root.left != null){
            getLeaf(root.left,leftVal);
        }
        if(root.right != null){
            getLeaf(root.right,leftVal);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Val = new ArrayList<>();
        List<Integer> root2Val = new ArrayList<>();
        getLeaf(root1,root1Val);
        getLeaf(root2,root2Val);
        if(root1Val.size() != root2Val.size()){
            return false;
        }else{
            for(int i = 0;i<root1Val.size();i++){
                if(root1Val.get(i) != root2Val.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean leafSimilar2(TreeNode root1,TreeNode root2){
        List<Integer> leafValueList1 = new ArrayList<>();
        if(root1 != null){
            dfs(root1,leafValueList1);
        }

        List<Integer> leafValueList2 = new ArrayList<>();
        if(root2 != null){
            dfs(root2,leafValueList2);
        }

        return leafValueList1.equals(leafValueList2);
    }

    public void dfs(TreeNode root,List<Integer> leafValueList){
        if(root.left == null && root.right == null){
            leafValueList.add(root.val);
        }else{
            if(root.left != null){
                dfs(root.left,leafValueList);
            }
            if(root.right != null){
                dfs(root.right,leafValueList);
            }
        }
    }


}
