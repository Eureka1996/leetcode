package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/19/019 - 22:38
 **/
public class L476_FindComplement {
    public int findComplement(int num) {
        int numTmp = num;
        int num2 = 1;
        while(numTmp >0){
            num2<<=1;
            numTmp>>=1;
        }
        num2-=1;
        return num^num2;
    }
}
