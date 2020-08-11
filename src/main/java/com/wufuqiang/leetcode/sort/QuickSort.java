package com.wufuqiang.leetcode.sort;

import java.util.Arrays;

/**
 * 快排
 * 从小到大排序
 */
public class QuickSort {
    public static void quickSort(int A[],int low ,int hight){
        if(low < hight){
            int q = partition(A,low,hight);
            quickSort(A,low,q-1);
            quickSort(A,q+1,hight);
        }
    }
    public static int partition(int A[] , int low , int hight){
        int i = low -1;  //i的起始位置，是最低位置的前一个位置，表示小于x的最高位置
        int x = A[hight];//选定的比较位置
        for(int j = low ; j < hight ; j++){
            if(A[j] <= x){ //判断条件，小于或等于指定值的数据需要做交换
                i = i+1;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        int tmp = A[i+1];
        A[i+1] = A[hight];
        A[hight] = tmp;
        return i +1;
    }

    public static void main(String[] args){
        int a[] = { 1,2,3,4,5,49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}