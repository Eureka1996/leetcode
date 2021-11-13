package com.wufuqiang.company.kuaishuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitString {
    private static double rate = 0;
    private static List<String> res;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inStr = scanner.nextLine();
		String[] inStrArray = inStr.split(" ");
		String[] strs = inStrArray[0].split(inStrArray[1]);
		int sMin = Integer.parseInt(inStrArray[2]);
		int sMax = Integer.parseInt(inStrArray[3]);
		dfs(strs,new ArrayList<>(),0,sMin,sMax,0,inStrArray[1]);

		for(String str : res){
			System.out.println(str);
		}
//		for(int i = 0;i<res.size();i++){
//			System.out.print(res.get(i));
//			if(i!= res.size()-1){
//				System.out.print(" ");
//			}
//		}
//		System.out.println(s);
	}
	public static void dfs(String[] strs, List<String> path, int index, int sMin, int sMax,int cnt,String sp){

		//递归结束条件，已经考虑到了最后一个字符串
		if(index == strs.length){
			//计算比率
			double newRate = cnt*1.0/path.size();
			//一句我调试的输出
			System.out.println("cnt:"+cnt+",size:"+path.size()+",newRate:"+newRate);

			if(rate < newRate){
				rate = newRate;
				//原来的path不能动，会影响回溯的过程，需要重新生成一个
				res = new ArrayList<>(path);
			}
			return;
		}

		//单独考虑当前的字符串
		//加入
		path.add(strs[index]);
		if (strs[index].length()>=sMin && strs[index].length() < sMax){
			dfs(strs,path,index+1,sMin,sMax,cnt+1,sp);
		}else{
			dfs(strs,path,index+1,sMin,sMax,cnt,sp);
		}
		//回溯回来时，返回原状
		path.remove(path.size()-1);

		//考虑当前字符串与前面一个字符串拼接起来的情况
		if(path.size()>0){
			String last = path.get(path.size() - 1);
			String newStr = last+sp+strs[index];
			if(last.length()>= sMin && last.length()<sMax) cnt-=1;
			path.set(path.size()-1,newStr);
			if(newStr.length()>=sMin && newStr.length()<sMax){
				dfs(strs,path,index+1,sMin,sMax,cnt+1,sp);
			}else{
				dfs(strs,path,index+1,sMin,sMax,cnt,sp);
			}

			//回溯回来时，返回原状
			if(last.length()>= sMin && last.length()<sMax) cnt+=1;
			path.set(path.size()-1,last);

		}

	}
}
