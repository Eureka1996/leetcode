package com.wufuqiang.leetcode;

import java.util.Arrays;
//组合 子集
public class L1079_NumTilePossibilities {
    private int result = 0;
    public int numTilePossibilities(String tiles) {
        char[] charTiles = tiles.toCharArray();
        boolean[] used = new boolean[charTiles.length];
        Arrays.sort(charTiles);
        backtrack(charTiles,used,0);
        System.out.println(result-1);
        return result-1;
    }
    public void backtrack(char[] titles,boolean[] used,int index){
        result+=1;
        for(int i = 0;i<titles.length;i++){
            if(used[i]) continue;
            if(i>0 && titles[i] == titles[i-1] && !used[i-1]) continue;
            used[i] = true;
            backtrack(titles,used,index+1);
            used[i]= false;
        }

    }

    public static void main(String[] args) {
        L1079_NumTilePossibilities l1079 = new L1079_NumTilePossibilities();
        l1079.numTilePossibilities("AAABBDDDFFC");
        System.out.println();
    }
}
