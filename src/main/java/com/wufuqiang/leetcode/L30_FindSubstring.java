package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//串联所有单词的子串 滑动窗口
public class L30_FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words == null || words.length == 0) return result;
        int oneWordLen = words[0].length();
        int wordsLen = oneWordLen * words.length;
        if(s.length() < wordsLen) return result;
        Map<String,Integer> wordsMap = new HashMap<>();
        for(String word:words){
            int cnt = wordsMap.getOrDefault(word, 0);
            cnt+=1;
            wordsMap.put(word,cnt);
        }
        Map<String,Integer> window = new HashMap<>();
        for(int i = 0 ;i<oneWordLen;i++){
            window.clear();
            int firstWordIndex = i;
            int lastWordIndex = i;
            int sameCnt = 0;
            while(firstWordIndex+wordsLen<=s.length()){
                String str = s.substring(lastWordIndex,lastWordIndex+oneWordLen);
                if(wordsMap.containsKey(str)){
                    int c = window.getOrDefault(str,0);
                    c+=1;
                    window.put(str,c);
//                    System.out.println(str);
                    if(c== wordsMap.get(str)){
                        sameCnt+=1;
                    }
                    if(sameCnt == wordsMap.size()){
                        result.add(firstWordIndex);
                    }

                    lastWordIndex+=oneWordLen;
                    if(lastWordIndex-firstWordIndex==wordsLen){
                        String deleteStr = s.substring(firstWordIndex,firstWordIndex+oneWordLen);
                        int deleteCnt = window.get(deleteStr);
                        if(deleteCnt == wordsMap.get(deleteStr)) sameCnt-=1;
                        deleteCnt-=1;
                        window.put(deleteStr,deleteCnt);
                        firstWordIndex+=oneWordLen;
                    }
                }else{
                    firstWordIndex = lastWordIndex+oneWordLen;
                    lastWordIndex = firstWordIndex;
                    window.clear();
                    sameCnt=0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L30_FindSubstring l30 = new L30_FindSubstring();
        String s = "wordgoodgoodgoodbestword";
        s = "barfoothefoobarman";
        String[] words = new String[]{"word","good","best","word"};
        words = new String[]{"foo","bar"};
        List<Integer> result = l30.findSubstring(s, words);
        for(int res : result) System.out.println(res);
    }
}
