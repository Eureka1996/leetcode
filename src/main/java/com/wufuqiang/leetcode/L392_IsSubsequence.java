package com.wufuqiang.leetcode;

public class L392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        boolean result = true;
        int i = -1;
        for(char sChar : s.toCharArray()){
            i = t.indexOf(sChar,i+1);
            if(i == -1){
                result = false;
                break;
            }
        }
        return result;
    }
}
