package com.wufuqiang.leetcode;
//保持城市天际线
public class L807_MaxIncreaseKeepingSkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int result = 0;
		if(grid == null || grid.length == 0) return result;
		int row = grid.length;
		int column = grid[0].length;
		int[] rowMax = new int[row];
		int[] columnMax = new int[column];

		for(int i = 0;i<row;i++){
			for(int j = 0;j<column;j++){
				if(rowMax[i] < grid[i][j]) rowMax[i] = grid[i][j];
				if(columnMax[j] < grid[i][j]) columnMax[j] = grid[i][j];
			}
		}

		for(int i = 0;i<row;i++){
			for(int j = 0;j<column ;j++){
				int newValue = Math.min(rowMax[i],columnMax[j]);
				result += (newValue-grid[i][j]);
			}
		}
		return result;
	}
}
