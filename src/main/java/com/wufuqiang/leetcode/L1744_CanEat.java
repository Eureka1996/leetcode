package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-01 08:55
 */
public class L1744_CanEat {
    public static void main(String[] args) {

    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for(int i=1;i<candiesCount.length;i++){
            sum[i] = sum[i-1]+candiesCount[i];
        }

        boolean[] answer = new boolean[queries.length];
        for(int i = 0;i<queries.length;i++){
            long x1 = queries[i][1] +1;
            long y1 = x1*queries[i][2];
            long x2 =queries[i][0] == 0? 1: sum[queries[i][0]-1]+1;
            long y2 = sum[queries[i][0]];
            answer[i] = !(x1 > y2 || y1 < x2);
        }
        return answer;
    }
}
