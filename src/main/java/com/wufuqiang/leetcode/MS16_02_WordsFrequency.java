package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MS16_02_WordsFrequency {

}

class WordsFrequency {

	private Map<String,Integer> stat = null;

	public WordsFrequency(String[] book) {
		stat = new HashMap<>();
		for(String w:book){
			int cnt = stat.getOrDefault(w, 0);
			cnt+=1;
			stat.put(w,cnt);
		}
	}

	public int get(String word) {
		return stat.getOrDefault(word,0);
	}
}
