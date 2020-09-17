package com.wufuqiang.jingdong.q20200917;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_W3 {
	private static int T = 0;
	private static int n = 0;
	private static int m = 0;
	private static int sx = 0;
	private static int sy = 0;
	private static int ex = 0;
	private static int ey = 0;
	private static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		String line = "";
		while(T>0){
//			String nm[] = sc.nextLine().split(" ");
			n = sc.nextInt();//Integer.parseInt(nm[0]);
			m = sc.nextInt();//Integer.parseInt(nm[1]);
			sc.nextLine();
			int[][] grid = new int[n][m];
			for(int i = 0;i<n;i++){
				line = sc.nextLine();
				for(int j = 0;j<m;j++){
					char c = line.charAt(j);
					if(c == 'S'){
						sx = i;
						sy = j;
					}else if(c == 'E'){
						ex = i;
						ey = j;
					}else if(c == '#'){
						grid[i][j] = 1;
					}
				}
			}

			if(sx==ex && sy == ey) {
				System.out.println("YES");
			}else{
				LinkedList<Integer> q = new LinkedList<>();
				q.offerLast(sx);
				q.offerLast(sy);
				boolean flag = false;

				while(!q.isEmpty()){
					int ox = q.pollFirst();
					int oy = q.pollFirst();
					if(ox == ex && oy == ey){
						flag = true;
						break;
					}
					for(int[] d:dir){
						int nx = ox + d[0];
						int ny = oy + d[1];
						if(nx>=0 && nx <n && ny >= 0 && ny < m && grid[nx][ny] == 0){
							q.offerLast(nx);
							q.offerLast(ny);
						}
					}
				}
				if(flag){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}

			}
			T--;
		}
		sc.close();
	}
}
