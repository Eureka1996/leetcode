package com.wufuqiang.company.alibaba;
//快速幂取模
public class SelectTeam {
	public static void main(String[] args) {
		int N = 1000000000;
		int mod = 1000000007;
		int tmpN = N -1;
		long sum = fastExpMod(2,tmpN,mod);
		System.out.println((sum*(N%mod))%mod);
	}

	/**
	 *
	 * @param b 底数
	 * @param e 次方
	 * @param m 模
	 * @return
	 */
	public static long fastExpMod(long b,long e,long m){
		long result = 1;
		while(e != 0){
			if((e&1) == 1){
				double tmp = result*1.0 *b;

				result = (long)((tmp) % m);
//				System.out.println("result:"+result);
			}
			e >>= 1;
			double tmp = b*1.0 * b ;
			b = (long)((tmp)%m);
		}
		return result;
	}
}
