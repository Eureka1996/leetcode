package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 19:07
 **/
public class L680_ValidPalindrome {

    public boolean validPalindromeRec(String s , int low , int high,boolean flag){
        if(low >= high){
            return true;
        }
        if(s.charAt(low) == s.charAt(high)){
            return validPalindromeRec(s,low+1,high-1,flag);
        }else{
            if(flag){
                return false;
            }else{
                return validPalindromeRec(s,low+1,high,!flag) || validPalindromeRec(s,low,high-1,!flag);
            }

        }
    }

    public boolean validPalindrome(String s) {
        return validPalindromeRec(s,0,s.length()-1,false);
    }

    public static void main(String[] args) {

    }
}
