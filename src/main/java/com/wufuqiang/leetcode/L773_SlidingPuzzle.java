package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-26 23:02
 */
public class L773_SlidingPuzzle {

    int[][] neighbors = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<3;i++){
            for(int j =0 ;j<3;j++){
                sb.append(board[i][j]);
            }
        }

        String initial = sb.toString();
        if("123450".equals(initial)) return 0;
        int step = 0;

        LinkedList<String> queue = new LinkedList<>();
        queue.offerLast(initial);
        Set<String> seen = new HashSet<>();
        seen.add(initial);

        while (!queue.isEmpty()){
            step+=1;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String status = queue.pollFirst();
                for(String nextStatus : get(status)){
                    if(!seen.contains(nextStatus)){
                        if("123450".equals(nextStatus)){
                            return step;
                        }
                        queue.offerLast(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> get(String status){
        List<String> res = new ArrayList<>();
        char[] chars = status.toCharArray();
        int x = status.indexOf('0');
        for(int y : neighbors[x]){
            swap(chars,x,y);
            res.add(new String(chars));
            swap(chars,x,y);

        }
        return res;
    }

    private void swap(char[] chars,int x ,int y){
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }
}
