package com.wufuqiang.leetcode;
//填充颜色
public class MS08_10_FloodFill {
	private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null || image.length == 0) return image;
		int row = image.length;
		int column = image[0].length;
		if (sr < 0 || sr >= row || sc < 0 || sc >= column) return image;
		int preColor = image[sr][sc];
		if(preColor == newColor) return image;
		dfs(image,row,column,sr,sc,preColor,newColor);
		return image;
	}

	public void dfs(int[][] image, int row, int column, int sr, int sc,int preColor, int newColor) {
		image[sr][sc] = newColor;
		for (int[] d : directions) {
			int nr = sr + d[0];
			int nc = sc + d[1];
			if (nr >= 0 && nr < row &&
					nc >= 0 && nc < column &&
					image[nr][nc] == preColor
			){
				dfs(image,row,column,nr,nc,preColor,newColor);
			}
		}
	}
}
