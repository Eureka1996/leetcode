package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MS16_19_PondSizes {
	private int area = 0;
	public int[] pondSizes(int[][] land) {
		List<Integer> result = new ArrayList<>();
		if(land == null || land.length<=0) return new int[0];
		for(int i = 0;i<land.length;i++){
			for(int j =0;j<land[0].length;j++){
				if(land[i][j] == 0){
					area=0;
					dfs(land,i,j);
					result.add(area);
				}
			}
		}
		int[] res = new int[result.size()];
		for(int i =0 ;i<result.size();i++){
			res[i] = result.get(i);
		}
		Arrays.sort(res);
		return res;
	}

	public void dfs(int[][] land,int i ,int j){
		if(i<0 || j < 0 || i>=land.length || j >= land[0].length || land[i][j] != 0) return;
		land[i][j] = 1;
		area+=1;
		dfs(land,i+1,j);
		dfs(land,i-1,j);
		dfs(land,i,j+1);
		dfs(land,i,j-1);
		dfs(land,i-1,j-1);
		dfs(land,i-1,j+1);
		dfs(land,i+1,j-1);
		dfs(land,i+1,j+1);
	}
}
