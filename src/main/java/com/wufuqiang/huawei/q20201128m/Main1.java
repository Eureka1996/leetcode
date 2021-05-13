package com.wufuqiang.huawei.q20201128m;


public class Main1 {
	public static void main(String[] args) {

	}

	public static String test(String str){
		if(str == null || str.length() == 0) return str;
		if(str.length() <= 2){
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<str.length();i++){
				char c = str.charAt(i);
				sb.append((char)(c+1));
			}
			return sb.toString();
		}

		int[] febi = new int[str.length()];
		febi[0] = 1;
		febi[1] = 1;
		for(int i = 2;i<str.length();i++){
			febi[i] = febi[i-1] + febi[i-2];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++){
			int tmp = str.charAt(i) - 'a';
			tmp = (tmp+febi[i])%26;
			char c = (char)(tmp+'a');
			sb.append(c);
		}
		return sb.toString();

	}
}
