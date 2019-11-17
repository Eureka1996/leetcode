package com.wufuqiang.leetcode;

import javafx.util.Pair;

import java.util.*;

public class L127_LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int wordLen = beginWord.length();

        Map<String,List<String>> allComboDict = new HashMap<String, List<String>>();

        wordList.forEach(item->{
            for(int i = 0 ; i < wordLen ; i ++){
                String newWord = item.substring(0,i)+"*"+item.substring(i+1,wordLen);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(item);
                allComboDict.put(newWord,transformations);
            }
        });

        Queue<Pair<String,Integer>> queue = new LinkedList<Pair<String,Integer>>();
        queue.add(new Pair<>(beginWord,1));

        HashMap<String,Boolean> visited = new HashMap<String,Boolean>();
        visited.put(beginWord,true);

        while(!queue.isEmpty()){
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for(int i = 0 ; i < wordLen ; i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,wordLen);

                for(String tmp:allComboDict.getOrDefault(newWord,new ArrayList<String>())){
                    if(tmp.equals(endWord)){
                        return level+1;
                    }
                    if(!visited.containsKey(tmp)){
                        visited.put(tmp,true);
                        queue.add(new Pair<>(tmp,level+1));

                    }
                }

            }
        }
        return 0;
    }

}
