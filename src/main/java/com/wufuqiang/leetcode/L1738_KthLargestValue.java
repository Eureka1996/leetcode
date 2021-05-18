package com.wufuqiang.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-19 00:30
 */
public class L1738_KthLargestValue {
    public static void main(String[] args) {

    }
    public int kthLargestValue(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        Queue<Integer>  queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                int f00 = i-1<0 || j-1< 0?0:matrix[i-1][j-1];
                int f01 = i-1<0 ? 0 :matrix[i-1][j];
                int f10 = j-1<0 ? 0 :matrix[i][j-1];
                matrix[i][j] = f00^f01^f10^matrix[i][j];
                queue.offer(matrix[i][j]);
            }
        }
        while (k-->1) queue.poll();
        return queue.poll();
    }
}
