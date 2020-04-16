package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L670_MaximumSwap {
    public static void main(String[] args) {

    }
    public int maximumSwap(int num) {
        int[] nums = num2Array(num);
        int[][] tmp = new int[2][nums.length];
        tmp[0][nums.length-1]  = nums[nums.length-1];
        tmp[1][nums.length-1] = nums.length-1;
        int max = nums[nums.length-1];
        int index = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
            tmp[0][i] = max;
            tmp[1][i] = index;
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != tmp[0][i]){
                index = tmp[1][i];
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
                break;
            }
        }
        return array2num(nums);
    }

    public int[] num2Array(int num){
        List<Integer> list = new ArrayList<>();
        while(num>0){
            list.add(num % 10);
            num /= 10;
        }
        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(list.size()-1-i);
        }
        return result;
    }

    public int array2num(int[] nums){
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum * 10 + nums[i];
        }
        return sum;
    }
}
