package com.wufuqiang.haoweilai.q20200920;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(" ");
		String[] fs = strs[0].split(",");
		String[] ss = strs[1].split(",");
		int count = 0;
		int fsi = 0;
		int ssi = 0;

		int pre = 0;
		if(fs.length == 0 && ss.length==0){

		}else if(fs.length == 0){
			ssi++;
			pre = Integer.parseInt(ss[0]);;
		}else if(ss.length == 0){
			fsi++;
			pre = Integer.parseInt(fs[0]);
		}else if(Integer.parseInt(fs[0]) > Integer.parseInt(ss[0])){
			ssi++;
			pre = Integer.parseInt(ss[0]);
		}else{
			fsi++;
			pre = Integer.parseInt(fs[0]);
		}
		System.out.print(pre);
		while(fsi<fs.length && ssi < ss.length){
			int next = 0;
			if(Integer.parseInt(fs[fsi]) > Integer.parseInt(ss[ssi])){
				next = Integer.parseInt(ss[ssi]);
				ssi++;
			}else{
				next = Integer.parseInt(fs[fsi]);
				fsi++;
			}
			if(pre != next){
				pre = next;
				System.out.print(" "+pre);
			}
		}
		while(fsi<fs.length){
			if(pre != Integer.parseInt(fs[fsi])){
				pre = Integer.parseInt(fs[fsi]);
				System.out.print(" "+pre);
			}
			fsi++;
		}
		while(ssi<ss.length){
			if(pre != Integer.parseInt(ss[ssi])){
				pre = Integer.parseInt(ss[ssi]);
				System.out.print(" "+pre);
			}
			ssi++;
		}
		System.out.println();
		sc.close();
	}
}
