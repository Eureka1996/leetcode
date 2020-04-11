package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L438_FindAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if(s.length() < p.length()){
			return result;
		}
		Map<Character,Integer> needs = new HashMap<>();
		Map<Character,Integer> window = new HashMap<>();
		for(char c : p.toCharArray()){
			int i = needs.getOrDefault(c, 0);
			i+=1;
			needs.put(c,i);
		}
		int right = 0;
		int left = 0;
		int match = 0;
		while(right < s.length()){
			char rc = s.charAt(right);
			if(needs.containsKey(rc)){
				int rci = window.getOrDefault(rc, 0);
				rci+=1;
				window.put(rc,rci);
				if(rci == needs.get(rc)){
					match+=1;
				}
				if(right-left+1==p.length()){
					if(match==needs.size()){
						result.add(left);
					}
					int i = window.get(s.charAt(left));
					i-=1;
					window.put(s.charAt(left),i);
					if(i!=needs.get(s.charAt(left))){
						match-=1;
					}
					left+=1;
				}
				right+=1;

			}else{
				right+=1;
				left = right;
				match=0;
				window.clear();
			}
		}
		return result;
	}
}
