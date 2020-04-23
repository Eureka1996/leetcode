package com.wufuqiang.leetcode;

public class MS08_11_WaysToChange {
	public int waysToChange(int n) {
		int result = 0;
		int mod = (int)1e9+7;
		for(int i = 0;i<=n/25;i++){
			int rest = n - i*25;
			int p = rest/5;
			int q = rest/10;
			result += (((long)(p+1)*(q+1))%mod - ((long)q*(q+1))%mod );
			result%=mod;
		}

		return result;
	}

	public static void main(String[] args) {
		MS08_11_WaysToChange ms = new MS08_11_WaysToChange();
		int res = ms.waysToChange(1000000);
		System.out.println(res);
	}
}
