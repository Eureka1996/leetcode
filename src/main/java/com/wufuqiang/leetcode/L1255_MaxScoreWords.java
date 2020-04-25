package com.wufuqiang.leetcode;
//得分最高的单词集合
public class L1255_MaxScoreWords {
	private String[] words;
    private int[] score;
	private int result=0;
	public int maxScoreWords(String[] words, char[] letters, int[] score) {

		this.words = words;
		this.score = score;
		int[] letterCnt = new int[26];
		for(char c : letters){
			letterCnt[c-'a'] = letterCnt[c-'a']+1;
		}
		dfs(0,0,letterCnt);
		return result;
	}

	public void dfs(int index,int sum,int[] letterCnt){
		if(index >= words.length) return;

		int[] letterCntTmp = letterCnt.clone();
		int tmpSum = 0;
		String curStr = this.words[index];
		for(char c : curStr.toCharArray()){
			if(letterCnt[c-'a']>0){
				tmpSum+=this.score[c-'a'];
				letterCnt[c-'a']--;
			}else{
				dfs(index+1,sum,letterCntTmp);
				return;
			}
		}

		this.result = Math.max(result,sum+tmpSum);
		dfs(index+1,sum+tmpSum,letterCnt);
		dfs(index+1,sum,letterCntTmp);

	}
}
