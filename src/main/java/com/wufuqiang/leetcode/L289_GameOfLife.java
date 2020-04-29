package com.wufuqiang.leetcode;
//生命游戏
public class L289_GameOfLife {
	public void gameOfLife(int[][] board) {
		int[] directions = {-1,0,1};
		int row = board.length;
		if(row == 0) return;
		int column = board[0].length;

		for(int i =0;i<row;i++){
			for(int j = 0 ;j<column;j++){
				int liveCnt = 0;
				for(int k=0;k<3;k++){
					for(int z = 0;z<3;z++){
						if(!(directions[k] == 0 && directions[z] == 0)){
							int r = i+directions[k];
							int c = j+directions[z];
							if(r>=0 && r<row &&
							   c>=0 && c<column &&
							   Math.abs(board[r][c]) == 1){
								liveCnt+=1;
							}
						}
					}
				}
				if(board[i][j] == 1 &&(liveCnt<2 || liveCnt>3)){
					board[i][j] = -1;
				}
				if(board[i][j] == 0 && liveCnt==3){
					board[i][j] = 2;
				}
			}
		}
		for(int i = 0;i<row;i++){
			for(int j =0;j<column;j++){
				if(board[i][j] == -1) board[i][j] = 0;
				else if(board[i][j] == 2) board[i][j] = 1;
			}
		}

	}
}
