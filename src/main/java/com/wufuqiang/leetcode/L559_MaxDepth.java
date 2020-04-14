package com.wufuqiang.leetcode;


import com.wufuqiang.leetcode.entries.Node;
//N叉就的高度 深度
public class L559_MaxDepth {

    private int depth = Integer.MIN_VALUE;

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        maxDepthRec(root,1);
        return depth;
    }

    public void maxDepthRec(Node root,int d){
        if(root.children == null || root.children.size() == 0){
            if(d>depth){
                depth=d;
            }
        }
        for(Node node : root.children){
            maxDepthRec(node,d+1);
        }
    }
}
