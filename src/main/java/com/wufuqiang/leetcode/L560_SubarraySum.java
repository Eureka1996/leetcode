package com.wufuqiang.leetcode;

import java.util.HashMap;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-29 00:22
 */
public class L560_SubarraySum {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prev = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0 ;i<nums.length;i++){
            prev += nums[i];
            if(mp.containsKey(prev-k)){
                count += mp.get(prev-k);
            }
            mp.put(prev,mp.getOrDefault(prev,0)+1);
        }
        return count;
    }
}
