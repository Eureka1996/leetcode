package com.wufuqiang.leetcode;

/**
 * 简化路径
 * 化简unix的路径
 */
public class L71_SimplifyPath {
	public static void main(String[] args) {
		L71_SimplifyPath l71 = new L71_SimplifyPath();
		String result = l71.simplifyPath2("/a//b////c/d//././/..");
		System.out.println(result);
	}
	public String simplifyPath(String path) {
		StringBuffer sb = new StringBuffer();
		String[] pathSplited = path.split("/");
		String[] pathTmp = new String[pathSplited.length];
		int index = -1;
		for(String str : pathSplited){
			str = str.trim();
			if("".equals(str) || ".".equals(str)){
				continue;
			}
			if("..".equals(str)){
				if(index>=0){
					index-=1;
				}
			}else{
				index+=1;
				pathTmp[index] = str;
			}
		}
		for(int i = 0;i<=index;i++){
			sb.append("/").append(pathTmp[i]);
		}
		if(index<0){
			sb.append("/");
		}

		return sb.toString();
	}


	public String simplifyPath2(String path) {
		StringBuffer sb = new StringBuffer();
		//将字符串拆分
		String[] pathSplited = path.split("/");
		int index = -1;
		for(String str : pathSplited){
			str = str.trim();
			if("".equals(str) || ".".equals(str)){
				continue;
			}
			if("..".equals(str)){
				if(index>=0){
					index-=1;
				}
			}else{
				index+=1;
				pathSplited[index] = str;
			}
		}
		for(int i = 0;i<=index;i++){
			sb.append("/").append(pathSplited[i]);
		}
		if(index<0){
			sb.append("/");
		}

		return sb.toString();
	}
}
