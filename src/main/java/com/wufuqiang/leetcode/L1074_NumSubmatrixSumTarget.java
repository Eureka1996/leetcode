package com.wufuqiang.leetcode;

import java.util.HashMap;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-29 00:34
 */
public class L1074_NumSubmatrixSumTarget {
    public static void main(String[] args) {

    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0;i<r;i++){
            int[] prev = new int[c];
            for(int j = i;j<r;j++){
                for(int z = 0;z<c;z++){
                    prev[z] += matrix[j][z];
                }
                count += subarraySum(prev,target);
            }
        }
        return count;
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
