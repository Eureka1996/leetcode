package com.wufuqiang.leetcode;

public class L72_MinDistance {
    public static int minDistance(String word1, String word2) {
        int distance[][] = new int[word1.length()+1][word2.length()+1];
        distance[0][0] = 0;
        for(int i = 1; i < word2.length()+1;i++){
            distance[0][i] = i;
        }
        for(int j = 1 ; j < word1.length()+1;j++){
            distance[j][0] = j;
        }
        for(int i = 1 ; i < word1.length()+1;i++){
            char c1 = word1.charAt(i-1);
            for(int j = 1; j < word2.length()+1;j++){
                char c2 = word2.charAt(j-1);

                int left = distance[i][j-1];
                int up = distance[i-1][j];
                int leftUp = distance[i-1][j-1];
                if(c1 == c2){
                    leftUp-=1;
                }
                int minLen = Math.min(Math.min(left,up),leftUp)+1;
                distance[i][j] = minLen;
            }
        }
        return distance[word1.length()][word2.length()];
    }
    public static void main(String[] args){
        System.out.println(minDistance("horse","ros"));
    }
}
