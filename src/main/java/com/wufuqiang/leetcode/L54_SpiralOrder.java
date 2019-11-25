package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L54_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0){
            return result;
        }
        int row = matrix.length;
        int column = matrix.length;
        boolean visited[][] = new boolean[row][column];
        int dr[] = new int[]{0,1,0,-1};
        int dc[] = new int[]{1,0,-1,0};
        int r = 0;
        int c = 0;
        int di = 0;
        for(int i = 0 ;i<row*column;i++){
            result.add(matrix[r][c]);
            visited[r][c] = true;
            int rTmp = r + dr[di];
            int cTmp = c + dc[di];
            if(0<=rTmp && rTmp < row && 0<= cTmp && cTmp < column && !visited[rTmp][cTmp]){
                r = rTmp;
                c = cTmp;
            }else{
                di = (di+1)%4;
                r+=dr[di];
                c+=dc[di];
            }
        }
        return result;
    }
}
