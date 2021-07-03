package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-03 11:45
 */
public class L451_FrequencySort {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for(int i =0;i<length;i++){
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0);
            frequency+=1;
            map.put(c,frequency);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)-> map.get(b)- map.get(a));

        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for(int i =0;i<size;i++){
            char c = list.get(i);
            int frequency = map.get(c);
            for(int j =0;j<frequency;j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
