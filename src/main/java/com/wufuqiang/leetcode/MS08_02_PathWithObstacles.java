package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MS08_02_PathWithObstacles {
	private int[][] directions= new int[][]{{0,1},{1,0}};
	private List<List<Integer>> res = null;
	private boolean flag = false;
	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		List<List<Integer>> result = new ArrayList<>();
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return new ArrayList<>();
		int row = obstacleGrid.length-1;
		int column = obstacleGrid[0].length-1;
		if(obstacleGrid[row][column] == 1) return new ArrayList<>();
		result.add(Arrays.asList(0,0));
		backtrack(result,obstacleGrid,row,column,0,0);
		return res == null ? new ArrayList<>() :res;
	}

	public void backtrack(List<List<Integer>> result,int[][] grid,int row,int column,int i,int j){
		if(i == row && j == column) {
			res = new ArrayList<>(result);
			flag = true;
			return;
		}
		if(flag) return;

		for(int[] direction:directions){
			int ni = i+direction[0];
			int nj = j+direction[1];
			if(ni>=0 && ni<=row && nj >= 0 && nj <= column && grid[ni][nj] != 1){
				result.add(Arrays.asList(ni,nj));
				backtrack(result,grid,row,column,ni,nj);
				result.remove(result.size()-1);
			}
		}

	}
}
