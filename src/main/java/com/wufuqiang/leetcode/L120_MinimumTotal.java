package com.wufuqiang.leetcode;

import java.util.List;

public class L120_MinimumTotal {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0){
			return 0;
		}
		int count = triangle.get(0).get(0);
		for(int i = 1 ; i < triangle.size();i++){
			List<Integer> row = triangle.get(i);
			List<Integer> lastRow = triangle.get(i - 1);
			for(int j = 0 ;j<row.size();j++ ){
				if(j==0){
					row.set(j,lastRow.get(j)+row.get(j));
				}else if(j==row.size()-1){
					row.set(j,lastRow.get(j-1)+row.get(j));
				}else{
					row.set(j,Math.min(lastRow.get(j-1)+row.get(j),lastRow.get(j)+row.get(j)));
				}
				if(i == triangle.size()-1){
					if(j==0){
						count = row.get(j);
					}else{
						count = Math.min(row.get(j),count);
					}
				}
			}
		}
		for(List<Integer> list:triangle){
			for(int i : list){
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		return count;
	}
}
