package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Wu Fuqiang
 * @create: 2021-08-01 21:27
 */
public class L337_KWeakestRows {
    public static void main(String[] args) {

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        List<int[]> power = new ArrayList<>();
        for (int i = 0;i<m;i++) {
            int l = 0;
            int r = n -1;
            int pos = -1;
            while(l <= r){
                int mid = (l+r)/2;
                if(mat[i][mid] == 0){
                    r = mid-1;
                }else{
                    pos = mid;
                    l = mid+1;
                }
            }
            power.add(new int[]{pos+1,i});

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((i1,i2)->{
            if(i1[0] != i2[0]){
                return i1[0] - i2[0];
            }else{
                return i1[1] - i2[1];
            }
        });

        power.forEach(i1 -> pq.offer(i1));

        int[] ans = new int[k];

        for(int i = 0;i<k;i++){
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}
