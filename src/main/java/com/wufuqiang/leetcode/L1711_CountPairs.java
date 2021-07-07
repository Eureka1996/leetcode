package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-07 18:45
 */
public class L1711_CountPairs {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for(int val : deliciousness) maxVal = Math.max(maxVal,val);

        int maxSum = maxVal*2;
        int pair = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for(int i = 0;i<n;i++){
            int val = deliciousness[i];
            for(int sum = 1;sum <= maxSum;sum <<= 1){
                int count = map.getOrDefault(sum-val,0);
                pair = (pair+count)%MOD;
            }
            map.put(val,map.getOrDefault(val,0)+1);
        }
        return pair;
    }
}
