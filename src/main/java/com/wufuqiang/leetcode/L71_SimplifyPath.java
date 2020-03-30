package com.wufuqiang.leetcode;

public class L71_SimplifyPath {
	public static void main(String[] args) {
		L71_SimplifyPath l71 = new L71_SimplifyPath();
		String result = l71.simplifyPath("/a//b////c/d//././/..");
		System.out.println(result);
	}
	public String simplifyPath(String path) {
		StringBuffer sb = new StringBuffer();
//		sb.append("/");
		String[] pathSplited = path.split("/");
//		for(String str:pathSplited){
//			System.out.println("|"+str+"|");
//		}
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
}
