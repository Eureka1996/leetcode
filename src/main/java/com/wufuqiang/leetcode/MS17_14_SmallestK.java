package com.wufuqiang.leetcode;

import java.util.Arrays;
// 最小的k个数
//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
public class MS17_14_SmallestK {

    //[1,3,5,7,2,4,6,8], k = 4
    public static void main(String[] args) {
        MS17_14_SmallestK ms = new MS17_14_SmallestK();
        int[] result = ms.smallestK(new int[]{1,3,5,7,2,4,6,8},0);
        System.out.println("----------------------------");
        for(int i : result){
            System.out.println(i);
        }
    }
    public int[] smallestK(int[] arr, int k) {
        if(arr == null || arr.length<k){
            return new int[]{};
        }
        if(k==0){
            return new int[]{};
        }
        int low = 0;
        int high = arr.length-1;
        int index = 0;
        while(true){
            index = partition(arr,low,high);
            System.out.println(index);
            int n = index-low+1;
            if(n==k){
                break;
            }else if(n>k){
                high = index-1;
            }else{
                k=k-n;
                low=index+1;
            }
        }
        return Arrays.copyOfRange(arr,0,index+1);
    }

    public int partition(int[] arr,int low ,int high){
        int x = arr[high];
        int i = low - 1;
        for(int j = low;j<high;j++){
            if(arr[j] < x){
                i+=1;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        i+=1;
        int tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;
        return i;
    }
}
