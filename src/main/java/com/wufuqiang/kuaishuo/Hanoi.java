package com.wufuqiang.kuaishuo;

/**
 * 汉诺塔
 */
public class Hanoi {
	private static int i = 0;//记录执行的次数

	public static void main(String[] args) {

		hannuota(5,"A","B","C");
		System.out.println("总共需要"+i+"步。");
	}

	public static void  move(int num,String a,String c){
		System.out.println("第"+(++i)+"步，将第"+num+"个盘子从"+a+"移到到"+c);
	}

	public static void hannuota(int num ,String a,String b ,String c){
		if(num ==1){
			move(num,a,c);
		}else{
			hannuota(num-1,a,c,b);
			move(num,a,c);
			hannuota(num-1,b,a,c);
		}

	}

}
