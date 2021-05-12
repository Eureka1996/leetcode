package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-12 21:35
 */
public class L57_Insert {
    public static void main(String[] args) {

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = intervals.length;
        for(int i =0;i<intervals.length;i++){
            if(intervals[i][1] < newInterval[0]){
                res.add(intervals[i]);
            }else if(newInterval[1] < intervals[i][0]){
                index = i;
                break;
            }else{
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }


        int[][] result = new int[res.size()+1+(intervals.length-index)][2];
        int i =0;
        for(i = 0;i<res.size();i++){
            result[i] = res.get(i);
        }
        result[i] = newInterval;
        for(i=i+1;index<intervals.length;i++,index++){

            result[i] = intervals[index];
        }

        return result;
    }
}
