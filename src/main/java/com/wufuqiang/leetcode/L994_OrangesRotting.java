package com.wufuqiang.leetcode;

import java.util.*;

public class L994_OrangesRotting {
	public int orangesRotting(int[][] grid) {
		int row = grid.length;
		if(row == 0) return 0;
		int column = grid[0].length;

		HashSet<List<Integer>> visited = new HashSet<>();
		LinkedList<List<Integer>> queue = new LinkedList<>();
		int freshCnt = 0;
		for(int i = 0;i<row;i++){
			for (int j =0;j<column;j++){
				if(grid[i][j] == 1) freshCnt+=1;
				else{
					List<Integer> l = Arrays.asList(i,j);
					visited.add(l);
					if(grid[i][j] == 2){
						queue.offerLast(l);
					}
				}
			}
		}

		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
		int step = 0;
		while(freshCnt != 0 && !queue.isEmpty()){
			int stepCnt = queue.size();
			step+=1;
			while(stepCnt >0){
				List<Integer> s = queue.pollFirst();
				for(int[] d:directions){
					int nrow = s.get(0) + d[0];
					int ncolumn = s.get(1) + d[1];
					if(nrow>=0 && nrow < row && ncolumn>=0 && ncolumn <column && visited.contains(Arrays.asList(nrow,ncolumn))){
						grid[nrow][ncolumn] = 2;
						freshCnt-=1;
						List<Integer> nl = Arrays.asList(nrow, ncolumn);
						visited.add(nl);
						queue.offerLast(nl);

					}
				}
				stepCnt-=1;

			}

		}
		if(freshCnt >0) return -1;
		return step;
	}
}
