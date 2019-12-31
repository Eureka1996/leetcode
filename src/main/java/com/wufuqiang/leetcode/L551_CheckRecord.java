package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L551_CheckRecord {
    public boolean checkRecord(String s) {
        boolean result = true;
        int aCount = 0;
        int lCount = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c=='A'){
                aCount += 1;
                if(aCount > 1){
                    return false;
                }
                lCount = 0;
            }else if(c=='L'){
                lCount+=1;
                if(lCount>2){
                    return false;
                }
            }else{
                lCount = 0;
            }
        }
        return true;
    }
}
