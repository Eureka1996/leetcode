package com.wufuqiang.leetcode;

/**
 * 最长回文子串
 * 1、一个字符，那它肯定是回文字符串
 * 2、两个字符，如果两个字符相等那它就是回文字符串，如果两个字符不相等那它就不是回文字符串
 *
 */
public class L5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //从一个字符串开始扩展
            int len1 = expandAroundCenter(s, i, i);
            //从两个字符串开始扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            //计算起始位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                //右边有可能比左边多一个
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}

