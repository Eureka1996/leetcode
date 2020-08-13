package com.wufuqiang.kuaishuo;

/**
 * 汉诺塔
 */
public class Hanoi {
	private static int i = 0;//记录执行的次数，需要搬运多少次

	public static void main(String[] args) {

		hannuota(5,"A","B","C");
		System.out.println("总共需要"+i+"步。");
	}

	public static void  move(int num,String a,String c){
		System.out.println("第"+(++i)+"步，将第"+num+"个盘子从"+a+"移到到"+c);
	}

	/**
	 *
	 * @param num 盘子个数
	 * @param a 源位置
	 * @param b 中间位置，过渡位置
	 * @param c 目的位置
	 */
	public static void hannuota(int num ,String a,String b ,String c){
		if(num ==1){
			move(num,a,c); //一个盘子时，直接从a移动到b
		}else{
			hannuota(num-1,a,c,b);//将num-1个盘子从a移动到b，借助c
			move(num,a,c);//将当前最大的盘子num从a移动到c
			hannuota(num-1,b,a,c);//将num-1个盘子从b移动到c，借助a
		}

	}

}
