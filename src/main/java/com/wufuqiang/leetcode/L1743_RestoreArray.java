package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-25 13:12
 */
public class L1743_RestoreArray {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {2,1},{3,4},{3,2}
        };
        L1743_RestoreArray l = new L1743_RestoreArray();
        int[] ints = l.restoreArray(input);
        System.out.println(ints);
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] adjacentPair : adjacentPairs) {
            List<Integer> adjacent1 = map.getOrDefault(adjacentPair[0], new ArrayList<Integer>());
            List<Integer> adjacent2 = map.getOrDefault(adjacentPair[1], new ArrayList<Integer>());
            adjacent1.add(adjacentPair[1]);
            adjacent2.add(adjacentPair[0]);
            map.put(adjacentPair[0],adjacent1);
            map.put(adjacentPair[1],adjacent2);
        }
        int[] result = new int[adjacentPairs.length+1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            System.out.println(String.format("key=%s,value=%s",entry.getKey(),value));
            if(value.size() == 1){
                result[0] = entry.getKey();
                break;
            }
        }

        for(int i = 1;i<=adjacentPairs.length;i++){
            int prev = result[i - 1];
            System.out.println(prev);
            List<Integer> neighbours = map.get(prev);
            int next = 0;
            System.out.println(neighbours);
            if(neighbours.size() ==1){
                next = neighbours.get(0);
            }else{
                next = neighbours.get(0) == result[i-2]?neighbours.get(1):neighbours.get(0);
            }
            result[i] = next;
        }
        return result;
    }
}
