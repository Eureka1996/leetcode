package com.wufuqiang.leetcode;

public class MS58_2_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] tmp = new char[s.length()];
        int tmpIndex = 0;
        for(int i = n;i<s.length();i++){
            tmp[tmpIndex] = s.charAt(i);
            tmpIndex+=1;
        }
        for(int i = 0;i<n;i++){
            tmp[tmpIndex] = s.charAt(i);
            tmpIndex+=1;
        }
        return String.valueOf(tmp);
    }
}
