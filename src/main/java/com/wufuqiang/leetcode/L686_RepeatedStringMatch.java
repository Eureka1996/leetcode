package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/15/015 - 9:50
 **/
public class L686_RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int bLen = B.length();
        String s = "";
        int count = 0;
        while(s.length() < bLen){
            count += 1;
            s+=A;
        }

        if(s.indexOf(B) != -1){
            return count;
        }

        s+=A;
        count += 1;
        if(s.indexOf(B) != -1){
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        L686_RepeatedStringMatch l686 = new L686_RepeatedStringMatch();
        int num = l686.repeatedStringMatch("abc","bcabca");
        System.out.println(num);
    }
}
