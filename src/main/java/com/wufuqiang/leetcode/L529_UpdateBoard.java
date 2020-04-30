package com.wufuqiang.leetcode;
//扫雷游戏
public class L529_UpdateBoard {
	public char[][] updateBoard(char[][] board, int[] click) {
		int n = board.length;
		int m = board[0].length;
		int row = click[0];
		int column = click[1];
		if(row>=0 && row < n &&
		   column >= 0 && column < m &&
		   (board[row][column] == 'M' || board[row][column] == 'X')){
			board[row][column] = 'X';
			return board;
		}
		int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
		int mcnt = 0;
		for(int[] d:directions){
			int nrow = row+d[0];
			int ncolumn = column+d[1];
			if(nrow>=0 && nrow < n &&
			   ncolumn >= 0 && ncolumn <m &&
			   board[nrow][ncolumn] == 'M') mcnt+=1;
		}
		if(mcnt>0){
			board[row][column] = (char)(mcnt+'0');
			return board;
		}
		board[row][column] = 'B';
		for(int[] d:directions){
			int nrow = row+d[0];
			int ncolumn = column+d[1];
			if(nrow>=0 && nrow < n &&
			   ncolumn >= 0 && ncolumn <m &&
			   board[nrow][ncolumn] == 'E'){
				updateBoard(board,new int[]{nrow,ncolumn});
			}
		}
		return board;
	}
}
