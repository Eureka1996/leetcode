package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 9:27
 **/
public class L191_HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for(int i = 0 ; i < 32 ; i++){
            if((n & mask) != 0){
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
