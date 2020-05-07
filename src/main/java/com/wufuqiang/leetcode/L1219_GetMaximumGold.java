package com.wufuqiang.leetcode;
//黄金矿工 回溯
public class L1219_GetMaximumGold {
    private int max = 0;
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0) return max;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] used = new boolean[row][column];
        for(int i = 0 ;i<row;i++){
            for(int j = 0;j<column;j++){
                if(grid[i][j] == 0){
                    used[i][j] = true;
                }
            }
        }

        for(int i =0;i<row;i++){
            for(int j =0;j<column;j++){
                if(grid[i][j] != 0){
                    used[i][j] = true;
                    backtrack(grid,grid[i][j],i,j,used);
                    used[i][j] = false;
                }
            }
        }

        return max;
    }

    public void backtrack(int[][] grid,int pathSum,int i , int j ,boolean[][] used){
        if(pathSum > max){
            max = pathSum;
        }
        for(int[] direction : directions){
            int nr = i+direction[0];
            int nc = j+direction[1];
            if(nr>=0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length
                    && !used[nr][nc]){
                used[nr][nc] = true;
                backtrack(grid,pathSum+grid[nr][nc],nr,nc,used);
                used[nr][nc] = false;
            }
        }
    }
}
