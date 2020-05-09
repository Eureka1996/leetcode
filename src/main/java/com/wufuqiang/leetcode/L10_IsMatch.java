package com.wufuqiang.leetcode;
//通配符 正则匹配
public class L10_IsMatch {
    public boolean isMatch(String s, String p) {
        //p是否为空
        if(p.isEmpty()) return s.isEmpty();
        //判断第一个字符是否相等
        boolean firstMatch = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //第二个字符为*
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return
                    //p中的前两个字符为空
                    isMatch(s,p.substring(2)) ||
                    //匹配s中的第一个字符
                    (firstMatch && isMatch(s.substring(1),p));
        }
        //第二个字符不为*
        else{
            //在第一个字符相等的情况下，去掉s、p的第一个字符再进行比较
            return firstMatch && (isMatch(s.substring(1),p.substring(1)));
        }
    }
}
