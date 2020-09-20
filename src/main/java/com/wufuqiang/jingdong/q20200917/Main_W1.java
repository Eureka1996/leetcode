package com.wufuqiang.jingdong.q20200917;

import java.util.Scanner;

public class Main_W1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("wufuqiang");
		String str = "20200fffffff20020ffaaa1999fff02345fff02020";
		System.out.println(getYears(str));
		sc.close();
	}

	public static String getYears(String line){
		//最终的结果
		StringBuilder sb = new StringBuilder();
		//数字开始的索引
		int start = 0;
		//数字结束的索引
		int end = 0;
		//标识是否遇到数据，false表示还没遇到数据，true表示遇到数字
		boolean flag = false;
		//表示start遇到的第一个数字是否有0
		boolean isBeginZero = false;
		while(start < line.length() && end < line.length()){
			if(flag){
				if(line.charAt(end) >= '0' && line.charAt(end) <= '9'){
					end++;
				}else{
					if(isBeginZero){
						isBeginZero=false;
					}else if(end-start == 4){
						int year = Integer.parseInt(line.substring(start, end));
						if(year>=1000 && year <= 3999){
							sb.append(year).append(" ");
						}
					}
					start = end +1;
					flag = false;
				}
			}else{
				if(line.charAt(start) == '0'){
					end = start+1;
					flag = true;
					isBeginZero = true;
				}else if(line.charAt(start) >= '1' && line.charAt(start) <= '9'){
					end = start+1;
					flag = true;
				}else{
					start++;
				}
			}

		}
		if(!isBeginZero && end-start ==4){
			sb.append(line.substring(start,end)).append(" ");
		}

		return sb.toString();
	}
}
