package com.wufuqiang.leetcode.mianshiti;

public class MS17_09_02_GetKthMagicNumber {

	public static void main(String[] args) {
		// 3,5,7,9,25,27,49,81
		MS17_09_02_GetKthMagicNumber ms = new MS17_09_02_GetKthMagicNumber();
		final int kth = ms.findKth(7);
		System.out.println(kth);

		System.out.println(ms.findKth2(1));
		System.out.println(ms.findKth2(2));
		System.out.println(ms.findKth2(3));
		System.out.println(ms.findKth2(4));
		System.out.println(ms.findKth2(5));
		System.out.println(ms.findKth2(6));
		System.out.println(ms.findKth2(7));
		System.out.println(ms.findKth2(8));
		System.out.println(ms.findKth2(9));
		System.out.println(ms.findKth2(10));
		System.out.println(ms.findKth2(11));
		System.out.println(ms.findKth2(12));
		System.out.println(ms.findKth2(99));
	}
	public int findKth(int k) {
		// write code here
		int n3 = 3;
		int n5 = 5;
		int n7 = 7;
		int res = -1 ;
		if(k== 1) return n3;
		else if (k == 2) return n5;
		else if( k == 3) return n7;
		else {
			while(k - 4 >= 0){
				int n3tmp = n3*3;
				int n5tmp = n5*5;
				int n7tmp = n7*7;
				int min = Math.min(Math.min(n3tmp,n5tmp),n7tmp);

				res = min;
				if(n3tmp == min){
					n3 = min;
				}else if(n5tmp == min){
					n5 = min;
				}else if(n7tmp == min){
					n7=min;
				}
				k-=1;
			}
			return res;
		}

	}

	public long findKth2(int k) {
		// write code here
		long n3 = 1;
		long n5 = 1;
		long n7 = 1;
		long res = -1 ;
		for(int i=0;i<k;i++){
			long n3Tmp = n3 * 3;
			long n5Tmp = n5 * 5;
			long n7Tmp = n7 * 7;
			long min = Math.min(n3Tmp,Math.min(n5Tmp,n7Tmp));
			res = min;
			if(n3Tmp == min){
				n3 = min;
			}else if(n5Tmp == min){
				n5 = min;
			}else if(n7Tmp == min){
				n7 = min;
			}
		}
		return res;
	}
}
