package com.wufuqiang.leetcode;

import java.util.TreeSet;

/**
 *
 * @author: Wu Fuqiang
 * @create: 2022-07-05 22:47
 */
public class L729_MyCalendar {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10,20);

        myCalendar.book(27,30);
        myCalendar.book(15,25);
    }
}

class MyCalendar {
    TreeSet<int[]> booked;

    public MyCalendar(){
        booked = new TreeSet<>((a,b)-> a[0] - b[0]);
    }

    public boolean book(int start, int end){
        if(booked.isEmpty()){
            booked.add(new int[]{start,end});
            return true;
        }

        int[] tmp = {end,0};
        // 大于或等于tmp的最小值
        int[] arr = booked.ceiling(tmp);
        System.out.println(arr);
        int[] prev = arr == null ? booked.last() : booked.lower(arr);

        if(arr == booked.first() || booked.lower(tmp)[1] <= start){
            booked.add(new int[]{start,end});
            return true;
        }
        return false;
    }
}
