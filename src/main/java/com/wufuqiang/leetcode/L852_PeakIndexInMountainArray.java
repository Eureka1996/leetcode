package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-15 00:02
 */
public class L852_PeakIndexInMountainArray {
    public static void main(String[] args) {

    }
    public int peakIndexInMountainArray(int[] A) {
        return peakIndexInMountainArray(A,0,A.length-1);
    }


    public int peakIndexInMountainArray(int[] A ,int low ,int high){
        int mid = low + (high-low)/2;
        if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
            return mid;
        }else if(A[mid] > A[mid-1]){
            return peakIndexInMountainArray(A,mid,high);
        }else{
            return peakIndexInMountainArray(A,low,mid);
        }

    }
}
