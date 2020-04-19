package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//N皇后
public class L52_TotalNQueens {

	private int result = 0;

	public static void main(String[] args) {
		char[] chars = new char[3];
//		chars[2] = '.';
		System.out.println(chars[2] == '\0');
	}
	public int totalNQueens(int n) {
		char[][] chars = new char[n][n];
		backtrack(chars,0);
		return result;

	}
	public void backtrack(char[][] chars,int curRow){
		int len = chars.length;
		if(len == curRow){
			result+=1;
			return;
		}
		for(int column = 0;column < len ;column++){
			boolean isok = true;
			for(int row  = 0;row<curRow;row++){
				if(chars[row][column] == 'Q'){
					isok = false;
					break;
				}
				if(column + (curRow-row) < len && chars[row][column+(curRow-row)] == 'Q'){
					isok = false;
					break;
				}
				if(column - (curRow-row) >= 0 && chars[row][column-(curRow-row)] == 'Q'){
					isok = false;
					break;
				}
			}
			if(!isok){
				continue;
			}
			chars[curRow][column] = 'Q';
			backtrack(chars,curRow+1);
			chars[curRow][column] = '\0';
		}
	}
}
