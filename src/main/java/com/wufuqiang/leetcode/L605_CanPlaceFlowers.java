package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n<=0){
            return true;
        }
        for(int i = 0 ;i < flowerbed.length ; i++){
            if(flowerbed[i] == 0){
                int pre = i - 1;
                int next = i+1;
                if((pre<0 ||flowerbed[pre] == 0) && ( next >= flowerbed.length || flowerbed[next] == 0)){
                    flowerbed[i] = 1;
                    n-=1;
                    if(n<=0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
