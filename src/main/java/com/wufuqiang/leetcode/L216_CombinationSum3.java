package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合总和
public class L216_CombinationSum3 {
    public static void main(String[] args) {
        L216_CombinationSum3 l216 = new L216_CombinationSum3();
        List<List<Integer>> result = l216.combinationSum3(3,9);
        for(List<Integer> list : result){
            for(int i : list){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(result,path,1,0,k,n);
        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> path,int begin,int sum,int k,int n){
        if(path.size() > k || sum > n) return;

        if(path.size() == k && sum == n){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = begin;i<=9;i++){
            sum+=i;
            path.add(i);
            backtrack(res,path,i+1,sum,k,n);
            path.remove(path.size()-1);
            sum-=i;
        }
    }
}
