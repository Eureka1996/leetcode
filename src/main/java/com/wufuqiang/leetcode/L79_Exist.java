package com.wufuqiang.leetcode;

import java.util.HashSet;

//单词搜索
public class L79_Exist {
    private boolean result = false;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        L79_Exist l79 = new L79_Exist();
//        char[][] board = {{'A','B','C','E'},
//                          {'S','F','C','S'},
//                          {'A','D','E','E'}};
        char[][] board = {};
        String word = "SEECCES";
        System.out.println(l79.exist(board,word));
    }
    public boolean exist(char[][] board, String word) {

        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(!result){
                    flag[i][j] = true;
                    backtrack(board,i,j,word,0,flag);
                    flag[i][j] = false;
                }else{
                    return result;
                }
            }
        }
        return result;
    }

    public void backtrack(char[][] board, int row, int column, String word, int index, boolean[][] flag){
        if(result) return;
        if(index>= word.length() || word.charAt(index) != board[row][column]) return;

        if(word.length() == index+1){
            result = true;
            return;
        }

        for(int[] d : directions){
            row+=d[0];
            column+=d[1];
            if(row>=0 && row < board.length &&
               column  >= 0 && column < board[0].length &&
               !flag[row][column]){
                flag[row][column] = true;
                backtrack(board,row,column,word,index+1,flag);
                flag[row][column] = false;
            }
            row-=d[0];
            column-=d[1];
        }
    }
}
