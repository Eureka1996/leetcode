package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * @author: Wu Fuqiang
 * @create: 2022-07-04 23:09
 */
public class L1200_MinimumAbsDifference {
    public static void main(String[] args) {

    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length < 2) return result;

        Arrays.sort(arr);
        // 间隔的初始值
        int best = Integer.MAX_VALUE;

        for(int i = 0;i<arr.length-1;i++){
            int curBest = arr[i+1] - arr[i];
            if( curBest < best){
                best = curBest;
                result.clear();
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }else if (curBest == best){
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }

        return result;
    }
}
