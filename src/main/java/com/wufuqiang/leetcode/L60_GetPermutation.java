package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//第k个排列
public class L60_GetPermutation {
    private String result = "";
    private int sum = 0;
    private int[] faction ;

    public static void main(String[] args) {
        L60_GetPermutation l60 = new L60_GetPermutation();
        String res = l60.getPermutation(9,296662);
        System.out.println(res);
    }
    public String getPermutation(int n, int k) {
        this.faction = new int[n+1];
        this.faction[0] = 1;
        this.faction[1] = 1;
        for(int i = 2;i<=n;i++){
            this.faction[i] = this.faction[i-1]*i;
        }
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        backtrack(path,n,k,used);
        return result;
    }

    public void backtrack(List<Integer> path,int n,int k,boolean[] used){
        if(path.size() == n){
            for(Integer i : path){
                result+=i.toString();
            }
            return ;
        }

        for(int i = 1;i<=n;i++){
            if(used[i-1]) continue;
            int tmpSum = sum+this.faction[n-path.size()-1];
            if(tmpSum < k ){
                sum = tmpSum;
                continue;
            }
            else{
                path.add(i);
                used[i-1] = true;
                backtrack(path,n,k,used);
            }
        }
    }
}
