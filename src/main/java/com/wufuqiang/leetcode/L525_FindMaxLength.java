package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-03 00:34
 */
public class L525_FindMaxLength {
    public static void main(String[] args) {

    }
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0;
        int maxLength = 0;
        for(int i= 0;i<nums.length;i++){
            if(nums[i] == 1){
                count+=1;
            }else{
                count-=1;
            }
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return maxLength;
    }
}
