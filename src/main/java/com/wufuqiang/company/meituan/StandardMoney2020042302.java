package com.wufuqiang.company.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StandardMoney2020042302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> result = new ArrayList<>();

		while(sc.hasNextLine()){
			StringBuffer sb = new StringBuffer();
			String money = sc.nextLine();
			int i = money.indexOf('.');
			boolean isFloat = i == -1?false:true;
			int start = 0;
			int end = money.length()-1;
			if(isFloat){
				end = i-1;
			}

			boolean isMenus = money.charAt(0) == '-'?true:false;
			if(isMenus) {
				sb.append('(');
				start+=1;
			}
			sb.append('$');
			int dhIndex = (end-start+1)%3;
			dhIndex = dhIndex == 0?3:dhIndex;
			int j = 0;
			for(j = start; j <= end;j++){
				if(dhIndex==0){
					sb.append(',');
					dhIndex = 3;
				}
				sb.append(money.charAt(j));
				dhIndex-=1;
			}
			if(isFloat){
				boolean enough = money.length()-j >= 3?true:false;
				if(enough){
					sb.append(money.substring(j,j+3));
				}else{
					sb.append(money.substring(j,money.length()));
					sb.append('0');
				}
			}else{
				sb.append(".00");
			}

			if(isMenus) sb.append(')');
			System.out.println(sb.toString());
			result.add(sb.toString());
		}
		for(String str:result){
			System.out.println(str);
		}
	}
}
