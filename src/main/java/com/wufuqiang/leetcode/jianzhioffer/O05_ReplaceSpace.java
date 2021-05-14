package com.wufuqiang.leetcode.jianzhioffer;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-14 17:58
 */
public class O05_ReplaceSpace {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        char [] array = new char[s.length()*3];
        char c ;
        int size = 0;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';

            }else{
                array[size++] = c;
            }
        }
        String str = new String(array,0,size);
        return str;
    }
}
