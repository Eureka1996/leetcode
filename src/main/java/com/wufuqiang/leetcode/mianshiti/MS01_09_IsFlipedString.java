package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-05 13:20
 */
public class MS01_09_IsFlipedString {
    public static void main(String[] args) {


    }

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1+s1).indexOf(s2) > -1;
    }
}
