package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2022-10-16 19:15
 *
 * 可能的二分法，对人员进行分组
 */
public class L886_PossibleBipartition {
    public static void main(String[] args) {

    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][]  matrix = new int[n+1][n+1];
        for (int[] dislike : dislikes) {
            // 记录不能分到同一组的人员编号
            matrix[dislike[0]][dislike[1]] = matrix[dislike[1]][dislike[0]] = 1;
        }

        // 记录分组情况
        int[] record = new int[n+1];

        for (int i = 1;i <= n;i++){
            if(record[i] == 0 && !dfs(matrix,record,i,1,n)){
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int[][] matrix, int[] record,int index,int group,int n){

        record[index] = group;
        for(int i = 1;i<= n;i++){
            if(i == index) continue;
            if(matrix[index][i] == 1 && record[i] == group){ // index与i不能同一个组，但发现i已经和index分到同一组了
                return false;
            }
            // index与i不能同一个组，i还没有进行分组，对i进行分组
            if(matrix[index][i] == 1 && record[i] == 0 && !dfs(matrix,record,i,group * -1,n)){
                return false;
            }
        }
        return true;
    }
}
