package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-02 01:07
 */
public class L523_CheckSubarraySum {
    public static void main(String[] args) {

    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if(m < 2) return false;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int remainder = 0;
        for(int i = 0;i<m;i++){
            remainder = (remainder+nums[i])%k;
            if(map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            }else{
                map.put(remainder,i);
            }
        }
        return false;
    }
}
