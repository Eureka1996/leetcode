package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-20 00:11
 */
public class L692_TopKFrequent {
    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue()?o1.getKey().compareTo(o2.getKey()):o2.getValue()-o1.getValue();
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        List<String> result = new ArrayList<>(k);
        while(k-->0){
            result.add(queue.poll().getKey());
        }

        return result;
    }

}
