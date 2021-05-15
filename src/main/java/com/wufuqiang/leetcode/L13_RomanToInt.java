package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-15 09:42
 */
public class L13_RomanToInt {
    private Map<Character,Integer> map = new HashMap<Character,Integer>(){{
        put('M',1000);
        put('D',500);
        put('C',100);
        put('L',50);
        put('X',10);
        put('V',5);
        put('I',1);
    }};

    public int romanToInt(String s) {
        int result = 0;
        int value = 0;
        for(int i = 0;i<s.length();i++){
            value = map.get(s.charAt(i));
            if(i+1<s.length() && value < map.get(s.charAt(i+1))){
                result -= value;
            }else{
                result += value;
            }
        }
        return result;
    }
}
