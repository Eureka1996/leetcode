package com.wufuqiang.leetcode;

import java.util.PriorityQueue;
//接雨水
public class L407_TrapRainWater {
	public int trapRainWater(int[][] heightMap) {
		int result = 0;
		if(heightMap == null || heightMap.length <= 0) return result;
		int row = heightMap.length;
		int column = heightMap[0].length;
		boolean[][] visited = new boolean[row][column];
		//创建优先队列，柱子高度大的排在前面
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[2]-o2[2]);
		//把最外一圈加入到优先队列，并在visited设置为已经访问
		for(int i = 0 ;i<row;i++){
			for(int j = 0;j < column;j++) {
				if(i==0 || i == row-1 || j == 0 || j == column-1){
					pq.offer(new int[]{i,j,heightMap[i][j]});
					visited[i][j] = true;
				}

			}
		}
		//移动方向，上，右，下，左
		int[] dirs = new int[]{-1,0,1,0,-1};
		while(!pq.isEmpty()){
			int[] p = pq.poll();
			for(int k = 0;k<4;k++){
				int nx = p[0] + dirs[k];
				int ny = p[1] + dirs[k+1];
				//新的坐标不超出边界，也没有被访问过
				if(nx>=0 && nx < row &&
				   ny>=0 && ny < column &&
				   !visited[nx][ny]){
					if(p[2] > heightMap[nx][ny]){
						result += (p[2] - heightMap[nx][ny]);
					}
					pq.offer(new int[]{nx,ny,Math.max(p[2],heightMap[nx][ny])});
					visited[nx][ny] = true;
				}
			}
		}
		return result;
	}
}
