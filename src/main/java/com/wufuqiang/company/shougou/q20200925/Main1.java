package com.wufuqiang.company.shougou.q20200925;

import sun.jvm.hotspot.utilities.Interval;

public class Main1 {
	private static int start = Integer.MAX_VALUE;
	private static int end = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Main1 m = new Main1();
		m.solve(3,3,"ABC","ABC");
	}

	public Interval solve (int n, int k, String str1, String str2) {
		// write code here
		boolean[] flag = new boolean[str1.length()];
		backtrack(n,k,str1,str2,flag,0,0,0,0);

//		System.out.println(start+","+end);
		return null;
	}

	public void backtrack(int n,int k , String str1,String str2,
	                      boolean[] flag,int curPosition,int rightCount,
	                      int startTmp,int endTmp){
		if(curPosition >= str1.length()){
			if(rightCount == k){
				start = Math.min(start,startTmp);
				end = Math.max(end,endTmp);
			}

			return;
		}

		if(str1.charAt(curPosition) == str2.charAt(curPosition)){
			backtrack(n,k,str1,str2,flag,curPosition+1,rightCount,startTmp,endTmp);
		}else{
			endTmp++;
			backtrack(n,k,str1,str2,flag,curPosition+1,rightCount,startTmp,endTmp);
			endTmp--;
		}

		if(rightCount<k){
			flag[curPosition] = true;

			if(str1.charAt(curPosition) == str2.charAt(curPosition)){

				backtrack(n,k,str1,str2,flag,curPosition+1,rightCount+1,startTmp+1,endTmp+1);
			}else{
				backtrack(n,k,str1,str2,flag,curPosition+1,rightCount+1,startTmp,endTmp);
			}
			flag[curPosition] = false;
		}








	}
}
