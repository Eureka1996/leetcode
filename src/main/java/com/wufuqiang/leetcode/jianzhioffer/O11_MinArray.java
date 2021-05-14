package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 18:57
 */
public class O11_MinArray {
    int result = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        partition(numbers,0,numbers.length-1);
        return result;
    }

    public void partition(int[] numbers,int low,int high){
        if(numbers[low] < numbers[high]){
            result = numbers[low];
            return ;
        }
        if(high - low <= 1) {
            result = Math.min(numbers[low],numbers[high]);
            return;
        }
        int mid = (low+high)/2;
        if(numbers[low] == numbers[mid]){//此情况不知道旋转点在哪一边
            //每次只能low向前移动一个位置
            partition(numbers,low+1,high);
        }else if(numbers[low] < numbers[mid]){  //左边顺序，旋转点在右方
            partition(numbers,mid,high);
        }else{
            partition(numbers,low,mid);
        }
    }

}
