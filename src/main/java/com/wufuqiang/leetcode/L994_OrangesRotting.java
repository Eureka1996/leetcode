package com.wufuqiang.leetcode;

import java.util.*;

/**
 * 腐烂的橘子
 */
public class L994_OrangesRotting {

	public static void main(String[] args) {
		L994_OrangesRotting l994 = new L994_OrangesRotting();
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		l994.orangesRotting2(grid);
	}

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

	public int orangesRotting2(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length;
		int column = grid[0].length;
		//记录新鲜橘子的个数
		int freshCount = 0;
		//记录分钟数
		int minute = 0;
		//记录所有烂橘子的位置，先弹入x，后弹入y
		Queue<Integer> rotted = new LinkedList<>();

		for(int i = 0 ;i<row;i++){
			for(int j = 0;j<column;j++){
				switch (grid[i][j]){
					case 1:
						//记录新鲜水果的个数
						freshCount++;
						break;
					case 2:
						//将烂橘子弹入队列
						rotted.offer(i);
						rotted.offer(j);
						break;
				}
			}

		}

		//传染的方向
		int[] direction = {-1,0,1,0,-1};

		int size = 0;
		int x = 0;
		int y = 0;
		int nx = 0;
		int ny =0;


		while(!rotted.isEmpty() && freshCount >0){
			//每次传染的橘子个数
			size = rotted.size()>>1;
			while(size>0){
				size--;
				x = rotted.poll();
				y = rotted.poll();
				//传染的过程
				for(int i = 0 ;i<4;i++){
					nx = x+direction[i];
					ny = y+direction[i+1];
					if(nx >=0 && nx < row && ny >= 0 && ny < column && grid[nx][ny] == 1){
						grid[nx][ny] = 2;
						//新生成的烂橘子
						rotted.offer(nx);
						rotted.offer(ny);
						freshCount--;
					}
				}

			}
			minute++;
		}
		return freshCount == 0?minute:-1;
	}
}
