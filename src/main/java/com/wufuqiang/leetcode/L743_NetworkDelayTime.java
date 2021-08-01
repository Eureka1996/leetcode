package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-08-02 01:02
 */
public class L743_NetworkDelayTime {
    public static void main(String[] args) {

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            List<int[]> list = map.getOrDefault(time[0], new ArrayList<>());
            list.add(time);
            map.put(time[0],list);
        }

        int result = 0;

        boolean[] used = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offerLast(k);
        used[k-1] = true;
        int count = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            int maxTime = 0;
            while (size > 0){
                int nodeNum = queue.pollFirst();
                List<int[]> list = map.get(nodeNum);
                for (int[] time : list) {
                    if(!used[time[1]-1]){
                        used[time[1]-1] = true;
                        queue.offerLast(time[1]);
                        count+=1;
                        maxTime = Math.max(maxTime,time[2]);
                    }
                }
                size-=1;
            }
        }


        return result;
    }
}
