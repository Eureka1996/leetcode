package com.wufuqiang.leetcode;

public class L130_Solve {
    public void solve(char[][] board) {
        if(board==null || board.length<=0) return;
        int row = board.length;
        int column = board[0].length;
        for(int i = 0;i<column;i++){
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        for(int i = 0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,column-1);
        }

        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board ,int i , int j){
        int row = board.length;
        int column = board[0].length;
        if(i<0 || j <0 ||
           i>=row || j >= column ||
           board[i][j] == 'X' || board[i][j] == '#') return;

        board[i][j] = '#';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
