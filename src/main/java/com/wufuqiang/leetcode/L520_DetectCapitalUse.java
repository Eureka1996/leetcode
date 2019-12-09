package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 19:28
 **/
public class L520_DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if(word.length()<=0){
            return true;
        }
        int upperCount = 0;
        for(int i = 0 ; i < word.length();i++){
            boolean isUpperCase = Character.isUpperCase(word.charAt(i));
            if(isUpperCase){
                upperCount+=1;
                if(upperCount != i+1 ){
                    return false;
                }
            }else if(upperCount>1){
                return false;
            }
        }
        return true;
    }
}
