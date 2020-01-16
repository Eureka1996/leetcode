package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L598_MaxCount {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for(int i = 0;i < ops.length;i++){
            if(row > ops[i][0]){
                row = ops[i][0];
            }
            if(col > ops[i][1]){
                col = ops[i][1];
            }
        }
        return row * col;
    }
}
