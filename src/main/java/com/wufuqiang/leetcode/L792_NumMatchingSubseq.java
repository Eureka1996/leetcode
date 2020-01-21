package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.WordNode;

import java.util.ArrayList;
import java.util.List;

public class L792_NumMatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<WordNode>[] buckets = new ArrayList[26];
        int result = 0;
        for(int i = 0 ; i < 26; i++){
            buckets[i] = new ArrayList<WordNode>();
        }
        for(String word : words){
            int index = word.charAt(0)-'a';
            buckets[index].add(new WordNode(word,0));
        }
        for(int i = 0 ; i < S.length() ;i++){
            int index = S.charAt(i) - 'a';
            ArrayList<WordNode> oldBucket = buckets[index];
            buckets[index] = new ArrayList<WordNode>();
            for(WordNode word : oldBucket){
                word.index+=1;
                if(word.index == word.word.length()){
                    result+=1;
                }else{
                    buckets[word.word.charAt(word.index) - 'a'].add(word);
                }
            }
            oldBucket.clear();
        }
        return result;
    }
}

