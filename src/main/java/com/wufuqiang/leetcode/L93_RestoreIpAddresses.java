package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;
//复原IP地址
public class L93_RestoreIpAddresses {
    public static void main(String[] args) {
        L93_RestoreIpAddresses l93 = new L93_RestoreIpAddresses();
        String str = "255255255255";
        str = "25525511035";
        List<String> results = l93.restoreIpAddresses(str);
        for(String result:results){
            System.out.println(result);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String[] path = new String[4];
        backtrack(result,path,0,-1,-1,s);
        return result;
    }

    public void backtrack(List<String> res,String[] path,int pathIndex,int beginIndexx,int endIndex,String s){
        if(endIndex==s.length()-1 && pathIndex == 4){
            res.add(String.join(".",path));
            return;
        }else if(pathIndex == 4) return;


        for(int i = endIndex+1;i<s.length() && i<= endIndex+3;i++){
            if(isBeginZero(s,endIndex+1,i)) continue;
            int value = str2Int(s,endIndex+1,i) ;
            if(value > 255) continue;
            path[pathIndex] = String.valueOf(value);
            backtrack(res,path,pathIndex+1,endIndex+1,i,s);
        }



    }

    public boolean isBeginZero(String s, int beginIndex,int endIndex){
        if((endIndex-beginIndex+1) > 1 && s.charAt(beginIndex) == '0') return true;
        return false;
    }

    public int str2Int(String str,int beginIndex,int endIndex){
        int sum = 0;
        for(int i = beginIndex;i<=endIndex;i++){
            sum = sum*10+ str.charAt(i)-'0';
        }
        return sum;
    }
}
