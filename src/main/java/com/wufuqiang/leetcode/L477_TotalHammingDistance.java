package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-28 00:13
 */
public class L477_TotalHammingDistance {
    public static void main(String[] args) {

    }

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0;i<30;i++){
            int c = 0;
            for(int num : nums){
                c += (num >> i) & 1;
            }
            res += c*(nums.length-c);
        }
        return res;
    }

}
