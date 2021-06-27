package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-27 21:18
 */
public class L909_SnakesAndLadders {
    public static void main(String[] args) {
        L909_SnakesAndLadders l = new L909_SnakesAndLadders();
        int i = l.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {36, 15, 36, -1, -1, -1}
        });
        System.out.println("step:"+i);
//        l.snakesAndLadders(new int[][]{
//                {36, 35, 34, 33, 32, 31},
//                {25, 26, 27, 28, 29, 30},
//                {24, 23, 22, 21, 20, 19},
//                {13, 14, 15, 16, 17, 18},
//                {12, 11, 10, 9, 8, 7},
//                {1, 2, 3, 4, 5, 6}
//        });
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] nums = new int[n*n];
        boolean[] seen = new boolean[n*n];
        for(int i =0;i<n;i+=2){
            for(int j=0;j<n;j++){
                nums[i*n+j] = board[n-1-i][j];
            }
        }
        for(int i = 1;i<n;i+=2){
            for(int j = n-1;j>=0;j--){
                nums[i*n + (n-1-j)] = board[n-1-i][j];
            }
        }

//        for(int num:nums){
//            System.out.println(num);
//        }
        int step = 0;
        int initial =  0;
//        if(nums[initial] != -1){
//            seen[initial] = true;
//            if(nums[initial] == n*n) return step;
//            initial = nums[initial] -1;
//        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offerLast(initial);

        while(!queue.isEmpty()){
            step+=1;
            int size = queue.size();
            while(size >0){
                size-=1;
                int cur = queue.pollFirst();
                for(int i =1;i<=6;i++){
                    int nextIndex = cur+i;
                    if(nums[cur+i] != -1 && !seen[cur+i]){
                        nextIndex = nums[cur+i]-1;
                        seen[cur+i] = true;
                    }else if(seen[cur+i]){
                        return -1;
                    }


                    if(nextIndex == n*n-1) return step;
                    if(nextIndex < n*n) queue.offerLast(nextIndex);
                    else break;
                }


            }
        }

        return -1;
    }
    public int snakesAndLadders2(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int nxt = p[0] + i;
                if (nxt > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(nxt, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n * n) { // 到达终点
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }
}
