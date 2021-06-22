package com.wufuqiang.leetcode.mianshiti;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-23 00:15
 */
public class MS01_04_CanPermutePalindrome {
    public static void main(String[] args) {

    }

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char tmp;
        for(int i = 0;i<s.length();i++){
            tmp = s.charAt(i);
            if(set.contains(tmp)) set.remove(tmp);
            else set.add(tmp);
        }
        return set.size() <= 1;
    }
}
