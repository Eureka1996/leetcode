package com.wufuqiang.company.alibaba;

import java.io.IOException;
import java.util.*;

/*
一个地图n*m，包含1个起点，1个终点，其他点包括可达点和不可达点。
每一次可以：上下左右移动，或使用1点能量从（i,j)移动到（n-1-i, m-1-j)，最多可以使用5点能量。
 */

public class SymmetryFly {

	public static int[][] diretions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) throws IOException {
		char[][] maze = getMaze();
		Set<List<Integer>> visited = new HashSet<>();
		int[] start = getStart(maze,visited);
		int d = dfs(maze, start[0], start[1], visited);
		System.out.println(d);
	}


	public static char[][] getMaze(){
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		char[][] matrix = new char[row][column];
		for(int i = 0 ; i < row ;i ++){
			String line = scanner.next().trim();
			for(int j = 0 ;j < column;j++){
				matrix[i][j] = line.charAt(j);
			}
		}
		return matrix;
	}

	public static int[] getStart(char[][] maze,Set<List<Integer>> visited){
		int[] start = new int[2];
		for(int i = 0; i < maze.length;i++){
			for(int j = 0 ; j < maze[0].length;j++){
				if(maze[i][j] == 'S'){
					start[0] = i;
					start[1] = j;
				}else if(maze[i][j] == '#'){
					visited.add(Arrays.<Integer>asList(i,j));
				}
			}
		}
		return start;
	}


	public static int dfs(char[][] maze,int sx,int sy,Set<List<Integer>> visited){
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offerLast(new int[]{sx,sy,0,5});
		int row = maze.length;
		int column = maze[0].length;

		while(!queue.isEmpty()){
			int[] ints = queue.pollFirst();
			int x = ints[0];
			int y = ints[1];
			int d = ints[2];
			int flyCount = ints[3];
//			System.out.println("x:"+x+",y:"+y);
			visited.add(Arrays.<Integer>asList(x,y));
			if(maze[x][y] == 'E'){
				return d;
			}
			for(int[] direction:diretions){
				int nx = x+direction[0];
				int ny = y+direction[1];
				if(nx>=0 && nx < row &&
						ny >=0 && ny < column &&
						!visited.contains(Arrays.<Integer>asList(nx,ny))){
//					System.out.println("nx:"+nx+",ny:"+ny);
					queue.offerLast(new int[]{nx,ny,d+1,flyCount});
				}
			}
			if(flyCount>0 && !visited.contains(Arrays.<Integer>asList(row-1-x,column-1-y))){
//				System.out.println("fly,nx:"+x+",ny:"+y);
				queue.offerLast(new int[]{row-1-x,column-1-y,d+1,flyCount-1});
			}

		}

		return -1;
	}
}
