package com.wufuqiang.company.vivo.q20200912;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
	private static int count = 0;
	private static int sx = 0;
	private static int sy = 0;
	private static int ex = 0;
	private static int ey = 0;
	private static int[] dir = {1,0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sx = sc.nextInt();
		sy = sc.nextInt();
		ex = sc.nextInt();
		ey = sc.nextInt();


		int[][] grid = new int[n][n];

		String line = sc.nextLine();
		char c ;

		for(int i = 0;i<n;i++){
			line = sc.nextLine();
			for(int j = 0;j<n;j++){
				c = line.charAt(j);
				if(c=='#' || c=='@'){
					grid[i][j] = 3;
				}else if(i==sx && j == sy){
					grid[i][j] = 1;
				}else if(i==ex && j == ey) {
					grid[i][j] = 2;
				}else{
					grid[i][j] = 0;
				}
			}
		}

		if(sx==ex && sy == ey) {
			System.out.println(0);
			return;
		}
		System.out.println(road(n,grid));
		sc.close();
	}

	public static int road(int n , int[][] grid){
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offerLast(sx);
		queue.offerLast(sy);
		grid[sx][sy] = 3;
		int nx = 0;
		int ny = 0;
		int levelSize = 0;

		while(!queue.isEmpty()){
			levelSize = queue.size()/2;
			count++;
			for(int i = 0;i<levelSize;i++){
				int ox = queue.pollFirst();
				int oy = queue.pollFirst();
				for(int j =0 ;j<4;j++){
					nx = ox+dir[j];
					ny = oy+dir[j+1];
					if(nx>=0 && nx <n && ny >= 0 && ny < n && grid[nx][ny] != 3){
						if(grid[nx][ny] == 2){
							return count;
						}else{
							queue.offerLast(nx);
							queue.offerLast(ny);
							grid[nx][ny] = 3;
						}
					}
				}
			}
		}
		return -1;

	}
}
