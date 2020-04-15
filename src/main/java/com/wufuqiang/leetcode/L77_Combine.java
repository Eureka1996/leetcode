package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//组合
public class L77_Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(result,path,1,n,k);
        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> path,int start,int n,int k){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start ; i<=n;i++){
            if(!path.contains(i)){
                path.add(i);
                backtrack(res,path,i+1,n,k);
                path.remove(path.size()-1);
            }
        }
    }
}
