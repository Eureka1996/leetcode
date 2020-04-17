package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56_Merge {
    public static void main(String[] args) {
        L56_Merge merge = new L56_Merge();
        merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
    public int[][] merge(int[][] intervals) {
        if(intervals ==  null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) return 1;
                else if(o1[0] < o2[0]) return -1;
                else{
                    if(o1[1] > o2[1]) return 1;
                    else if(o1[1] < o2[1]) return -1;
                    else return 0;
                }
            }
        });

        for(int[] i:intervals){
            System.out.println(i[0]+","+i[1]);
        }
        System.out.println("----------------------------");

        int[][] result = new int[intervals.length][2];
        int index = 0;
        result[0] = intervals[0];
        int count = intervals.length;
        for(int i = 1;i<intervals.length;i++){
            if(result[index][1] >= intervals[i][0]){
                result[index][1] = Math.max(result[index][1],intervals[i][1]);
                count-=1;
            }else{
                result[index+1] = intervals[i];
                index+=1;
            }
        }
        result = Arrays.copyOfRange(result,0,count);
//        for(int[] i:result){
//            System.out.println(i[0]+","+i[1]);
//        }

        return result;
    }
}
