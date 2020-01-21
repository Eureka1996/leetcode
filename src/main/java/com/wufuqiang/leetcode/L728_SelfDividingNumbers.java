package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            if(isSelfDividing(i)){
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSelfDividing(int num){
        boolean flag = true;
        int numTmp = num;
        while(numTmp > 0){
            int mod = numTmp % 10;
            if(mod == 0){
                flag =  false;
                break;
            }
            numTmp /= 10;
            if(num % mod != 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
