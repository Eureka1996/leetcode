package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-07-12 14:17
 */
public class L275_HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(citations[mid] >= n - mid){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return n - left;
    }
}
