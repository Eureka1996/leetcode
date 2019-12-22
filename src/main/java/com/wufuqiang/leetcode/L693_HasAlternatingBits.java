package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 9:16
 **/
public class L693_HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        if(n == 0){
            return true;
        }
        int mod = n % 2;
        n /= 2;
        while(n>0){
            int modTmp = n % 2;
            if(modTmp == mod){
                return false;
            }
            mod = modTmp;
            n /= 2;
        }
        return true;
    }
}
