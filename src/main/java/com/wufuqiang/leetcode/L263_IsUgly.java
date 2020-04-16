package com.wufuqiang.leetcode;

public class L263_IsUgly {
    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }
    public static boolean isUgly(int num) {
        if(num < 1 ) return false;
        boolean flag = true;
        int tmpNum = num;
        while(tmpNum != 1){
            if(tmpNum % 2 == 0){
                tmpNum/=2;
            }else if(tmpNum % 3 == 0){
                tmpNum/=3;
            }else if(tmpNum % 5 == 0){
                tmpNum/=5;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
