package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-18 23:18
 */
public class L1442_CountTriplets {
    public static void main(String[] args) {

    }

    public int countTriplets(int[] arr) {
        Map<Integer,Integer> cnt = new HashMap<>();
        Map<Integer,Integer> indexTotal = new HashMap<>();
        int ans = 0;
        int s = 0;
        for(int k = 0;k<arr.length;k++){
            int val = arr[k];
            if(cnt.containsKey(s^val)){
                ans = ans + k*cnt.get(s^val) - indexTotal.get(s^val);
            }
            cnt.put(s,cnt.getOrDefault(s,0)+1);
            indexTotal.put(s,indexTotal.getOrDefault(s,0)+k);
            s^=val;
        }
        return ans;
    }
}
