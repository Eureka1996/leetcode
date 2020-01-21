package com.wufuqiang.leetcode;

public class L91_NumDecodings {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 0 || chars[0] == '0'){
            return 0;
        }
        if(chars.length == 1){
            return 1;
        }
        int[] nums = new int[chars.length];
        nums[0] = 1;
        if(chars[0] == '1'){
            if(chars[1] == '0'){
                nums[1] = 1;
            }else{
                nums[1] = 2;
            }
        }else if(chars[0] == '2'){
            if( '1' <= chars[1] && chars[1] <= '6'){
                nums[1] = 2;
            }else{
                nums[1] = 1;
            }
        }else{
            if(chars[1] == '0'){
                return 0;
            }else{
                nums[1] =1;
            }
        }

        for(int i = 2 ; i < chars.length;i++){
            if(chars[i-1] == '0'){
                if(chars[i] == '0'){
                    return 0;
                }else{
                    nums[i] = nums[i-1];
                }
            }else if(chars[i-1] == '1'){
                if(chars[i] == '0'){
                    nums[i] = nums[i-2];
                }else{
                    nums[i] = nums[i-1] + nums[i-2];
                }
            }else if(chars[i-1] == '2'){
                if(chars[i] == '0'){
                    nums[i] = nums[i-2];
                }else if('1'<=chars[i] && chars[i] <= '6'){
                    nums[i] = nums[i-1] + nums[i-2];
                }else{
                    nums[i] = nums[i-1];
                }
            }else{
                if(chars[i] == '0'){
                    return 0;
                }else{
                    nums[i] = nums[i-1];
                }
            }
        }
        return nums[chars.length-1];
    }
}
