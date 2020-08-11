package com.wufuqiang.tencent;

/**
 * 找出给定的数组中缺失的最小自然数
 * [5,6,0,1]
 * 2
 */
public class Timu1 {
	public static int findMinNum(int[] arr){
		int index = 0;
		//最终结果有可能的最大值
		int max = arr.length;
		int tmp = 0;
		while(index < max){
			//大于最大值，将最后一个转移到现在的位置，缩小最小值
			if(arr[index]>=max){
				max-=1;
				arr[index]=arr[max];
			}else if(index != arr[index]){
				tmp = arr[arr[index]];
				arr[arr[index]] = arr[index];
				arr[index] = tmp;
			}else{
				index+=1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = {30,92,71,40};
		int minNum = findMinNum(arr);
		System.out.println(minNum);
	}
}
