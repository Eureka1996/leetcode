package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-11 09:15
 */
public class L1734_Decode {
    public static void main(String[] args) {

    }

    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int all = 0;
        for(int i = 1 ;i<=n;i++){
            all ^= i;
        }
        int odd = 0;
        for(int i = 1;i<encoded.length;i+=2){
            odd ^= encoded[i];
        }

        int[] prem = new int[n];
        prem[0] = all ^ odd;
        for(int i = 1;i<n;i++){
            prem[i] = prem[i-1] ^ encoded[i-1];
        }
        return prem;
    }
}
