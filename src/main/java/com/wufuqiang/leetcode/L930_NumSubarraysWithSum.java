package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-08 16:23
 */
public class L930_NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> cnt = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int num : nums){
            cnt.put(sum,cnt.getOrDefault(sum,0)+1);
            sum+=num;
            res += cnt.getOrDefault(sum-goal,0);
        }
        return res;
    }
}
