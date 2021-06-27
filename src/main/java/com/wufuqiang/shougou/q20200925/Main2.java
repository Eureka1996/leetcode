package com.wufuqiang.shougou.q20200925;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Main2 m = new Main2();
		String s = m.rotatePassword(new String[]{"1101", "1010", "1111", "1110"}, new String[]{"ABCD","EFGH","IJKL","MNPQ"});
		System.out.println(s);
	}
//	["1101","1010","1111","1110"],["ABCD","EFGH","IJKL","MNPQ"]
	public String rotatePassword (String[] s1, String[] s2) {
		// write code here
		StringBuilder sb = new StringBuilder();
		List<int[]> zero = new ArrayList<>(s1.length*s1.length);
		for(int i = 0;i<s1.length;i++){
			for(int j = 0;j<s1.length;j++){
				if(s1[i].charAt(j) == '0'){
					sb.append(s2[i].charAt(j));
					zero.add(new int[]{i,j});
				}
			}
		}

		for(int i = 0;i<3;i++){
			for(int[] z : zero){
				int tmp = z[0];
				z[0] = z[1];
				z[1] = s1.length-tmp-1;
			}

			Collections.sort(zero, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] > o2[0]){
						return 1;
					}else if(o1[0] < o2[0]){
						return -1;
					}else{
						if(o1[1] > o2[1]){
							return 1;
						}else if(o1[1] < o2[1]){
							return -1;
						}else{
							return 0;
						}
					}
				}
			});
			for(int[] z : zero){
				sb.append(s2[z[0]].charAt(z[1]));
			}

		}

		return sb.toString();
	}
}
