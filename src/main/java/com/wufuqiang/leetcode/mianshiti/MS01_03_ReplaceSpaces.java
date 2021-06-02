package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-02 13:44
 */
public class MS01_03_ReplaceSpaces {
    public static void main(String[] args) {

    }
    public String replaceSpaces(String S, int length) {
        char[] c = new char[length*3];
        int index = 0;
        int lengthTmp = 0;
        while(lengthTmp < length){
            char ct = S.charAt(lengthTmp);
            if(ct == ' '){
                c[index] = '%';
                index+=1;
                c[index] = '2';
                index+=1;
                c[index] = '0';
                index+=1;
            }else{
                c[index] = ct;
                index+=1;
            }
            lengthTmp+=1;
        }
        return new String(c,0,index);
    }
}
