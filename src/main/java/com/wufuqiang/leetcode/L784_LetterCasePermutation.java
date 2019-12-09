package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 13:23
 **/
public class L784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        int B = 0;
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                B++;
            }
        }
        for(int bits = 0; bits < 1 << B;bits++){
            int b = 0;
            StringBuilder word = new StringBuilder();
            for(char letter : S.toCharArray()){
                if(Character.isLetter(letter)){
                    if(((bits>>b++)&1)== 1){
                       word.append(Character.toLowerCase(letter));
                    }else{
                        word.append(Character.toUpperCase(letter));
                    }
                }else{
                    word.append(letter);
                }
            }
            result.add(word.toString());
        }
        return result;
    }
}
