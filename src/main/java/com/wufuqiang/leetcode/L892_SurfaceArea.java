package com.wufuqiang.leetcode;

public class L892_SurfaceArea {
	public int surfaceArea(int[][] grid) {
		int result = 0;
		if(grid == null || grid.length == 0){
			return result;
		}
		int row = grid.length;
		int column = grid[0].length;
		for(int i = 0 ;i<row;i++){
			for(int j = 0 ;j < column;j++){
				if(grid[i][j] != 0){
					int top = 0;
					int button = 0;
					int left = 0 ;
					int right = 0;
					if(i>0){
						top = grid[i-1][j];
					}
					if(i<row-1){
						button = grid[i+1][j];
					}
					if(j>0){
						left = grid[i][j-1];
					}
					if(j<column-1){
						right = grid[i][j+1];
					}
					int current = grid[i][j];
					result = result + 2 +
							Math.max(current-top,0)+
							Math.max(current-button,0)+
							Math.max(current-left,0)+
							Math.max(current-right,0);
				}
			}
		}

		return result;
	}
}
