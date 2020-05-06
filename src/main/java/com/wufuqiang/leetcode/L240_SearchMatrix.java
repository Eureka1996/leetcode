package com.wufuqiang.leetcode;
//矩阵搜索 搜索二维矩阵
public class L240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;

        int r = row-1;
        int c = 0;
        boolean result = false;
        int newColumn = 0;
        while(r>= 0 && r<row && c >= newColumn && c <column){
            if(matrix[r][c] == target) {
                result = true;
                break;
            }else if(matrix[r][c] > target){
                row = r;
                r=r-1;
            }else{
                c+=1;
                newColumn=c;
            }
        }

        return result;
    }
}
