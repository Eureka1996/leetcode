package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2021-08-05 00:30
 */
public class L802_EventualSafeNodes {
    public static void main(String[] args) {

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0;i<n;i++){
            if(safe(graph,color,i)){
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean safe(int[][] graph, int[] color, int i) {
        if(color[i] > 0) return color[i] == 2;
        color[i] = 1;
        for (int x : graph[i]) {
            if(!safe(graph,color,x)){
                return false;
            }
        }
        color[i] = 2;
        return true;
    }
}
