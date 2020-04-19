package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//N皇后
public class MS08_12_SolveNQueens {
	public static void main(String[] args) {
		MS08_12_SolveNQueens ms08 = new MS08_12_SolveNQueens();
		List<List<String>> lists = ms08.solveNQueens(8);
	}
	public List<List<String>> solveNQueens(int n) {
		char[][] chars = new char[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				chars[i][j] = '.';
			}
		}
		List<List<String>> result = new ArrayList<>();
		backtrack(chars,0,result);
		return result;
	}
	public void backtrack(char[][] chars,int curRow,List<List<String>> result){
		int len = chars.length;
		if(len == curRow){
			List<String> l = new ArrayList<>();
			for(char[] c : chars){
				String s = String.valueOf(c);
				l.add(s);
			}
			result.add(l);
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
			backtrack(chars,curRow+1,result);
			chars[curRow][column] = '.';
		}
	}
}
