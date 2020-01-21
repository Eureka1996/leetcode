package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_LetterCombinations {

    private Map<Character,String> numToLetter = new HashMap<>();

    public L17_LetterCombinations(){
        numToLetter.put('2',"abc");
        numToLetter.put('3',"def");
        numToLetter.put('4',"ghi");
        numToLetter.put('5',"jkl");
        numToLetter.put('6',"mno");
        numToLetter.put('7',"pqrs");
        numToLetter.put('8',"tuv");
        numToLetter.put('9',"wxyz");
    }

    public void letterCombinationsRec(String digits,int index,String preStr,List<String> result){
        if(index == digits.length()){
            result.add(preStr);
        }
        String str = numToLetter.get(digits.charAt(index));
        for(int i = 0 ; i < str.length() ;i++){
            char c = str.charAt(i);
            letterCombinationsRec(digits,index+1,preStr+c,result);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        letterCombinationsRec(digits,0,"",result);
        return result;
    }
}
