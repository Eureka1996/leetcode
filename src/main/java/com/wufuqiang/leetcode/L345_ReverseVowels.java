package com.wufuqiang.leetcode;

public class L345_ReverseVowels {
    public String reverseVowels(String s) {
        if(s== null){
            return "";
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length-1;
        while(low < high){
            if(!(
                    chars[low] == 'a' || chars[low] == 'e' ||
                    chars[low] == 'i' || chars[low] == 'o' ||
                    chars[low] == 'u' || chars[low] == 'A' ||
                    chars[low] == 'E' || chars[low] == 'I' ||
                    chars[low] == 'O' || chars[low] == 'U')){
                low++;
                continue;
            }
            if(!(
                    chars[high] == 'a' || chars[high] == 'e' ||
                    chars[high] == 'i' || chars[high] == 'o' ||
                    chars[high] == 'u' || chars[high] == 'A' ||
                    chars[high] == 'E' || chars[high] == 'I' ||
                    chars[high] == 'O' || chars[high] == 'U')){
                high--;
                continue;
            }
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
        return new String(chars);
    }
}
