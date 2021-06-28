package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-28 23:35
 */
public class L815_NumBusesToDestination {
    public static void main(String[] args) {

    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int site:routes[i]){
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for(int j : list){
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site,list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis,-1);
        LinkedList<Integer> queue = new LinkedList<>();
        for(int bus:rec.getOrDefault(source,new ArrayList<>())){
            dis[bus] = 1;
            queue.offerLast(bus);
        }

        while (!queue.isEmpty()){
            int x = queue.pollFirst();
            for(int y = 0;y<n;y++){
                if(edge[x][y] && dis[y] == -1){
                    dis[y] = dis[x]+1;
                    queue.offerLast(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int bus:rec.getOrDefault(target,new ArrayList<>())){
            if(dis[bus] != -1){
                ret = Math.min(ret,dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE?-1:ret;
    }
}
