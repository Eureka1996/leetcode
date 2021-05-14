package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 17:29
 */
public class L171_TitleToNumber {
    public static void main(String[] args) {

    }
    private static Map<Character,Integer> map = new HashMap<Character,Integer>(){{
        put('A',1);put('B',2);put('C',3);put('D',4);put('E',5);
        put('F',6);put('G',7);put('H',8);put('I',9);put('J',10);
        put('K',11);put('L',12);put('M',13);put('N',14);put('O',15);
        put('P',16);put('Q',17);put('R',18);put('S',19);put('T',20);
        put('U',21);put('V',22);put('W',23);put('X',24);put('Y',25);
        put('Z',26);
    }};
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char c ;
        for(int i = 0;i<columnTitle.length();i++){
            c = columnTitle.charAt(i);
            result = result* 26 + map.get(c);
        }
        return result;
    }
}
