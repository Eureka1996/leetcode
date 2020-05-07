package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ author wufuqiang
 **/
//顺序次数 顺次数 回溯
public class L1291_SequentialDigits {
    public static void main(String[] args) {
        L1291_SequentialDigits l1291 = new L1291_SequentialDigits();
        List<Integer> result = l1291.sequentialDigits(1000, 13000);
        for(Integer r : result){
            System.out.println(r);
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<Integer>();
        backtrack(result,0,0,low,high);
        Collections.sort(result);
        return result;
    }

    public void backtrack(List<Integer> result,int path,int prenum,int low,int high){
        if(path >= low && path<= high){
            result.add(path);
        }

        if(path > high) return;

        if(prenum == 0){
            for(int  i = 1;i<=9;i++){
                path=path*10+i;
                backtrack(result,path,i,low,high);
                path /= 10;
            }
        }else if(prenum+1<=9){
                path = path*10 + (prenum+1);
                backtrack(result,path,prenum+1,low,high);
                path = path/10;

        }



//        for(int i = prenum+1;i<=9;i++){
//            path = path*10+i;
//            backtrack(result,path,i,low,high);
//            path = path/10;
//        }
    }


}
