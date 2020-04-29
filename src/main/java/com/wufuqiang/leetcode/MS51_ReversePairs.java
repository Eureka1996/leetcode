package com.wufuqiang.leetcode;
//逆序对数
public class MS51_ReversePairs {
	public int reversePairs(int[] nums) {
		if(nums.length<2) return 0;

		int[] tmp = new int[nums.length];
		return reversePairs(nums,0,nums.length-1,tmp);
	}

	public int reversePairs(int[] nums,int left,int right,int[] tmp){
		if(left==right) return 0;
		int mid = (left+right)/2;
		int leftCnt = reversePairs(nums,left,mid,tmp);
		int rightCnt = reversePairs(nums,mid+1,right,tmp);
		if(nums[mid]<=nums[mid+1]){
			return leftCnt+rightCnt;
		}
		int crossCnt = mergeAndCount(nums,left,mid,right,tmp);

		return leftCnt+rightCnt+crossCnt;
	}

	public int mergeAndCount(int[] nums,int left,int mid,int right,int[] tmp){
		for(int i = left;i<=right;i++){
			tmp[i] = nums[i];
		}
		int i = left;
		int j = mid+1;
		int count = 0;
		for(int k = left ;k<=right;k++){
			if(i==mid+1){
				nums[k] = tmp[j];
				j++;
			}else if(j==right+1){
				nums[k] = tmp[i];
				i++;
			}else if(tmp[i] <= tmp[j]){
				nums[k] = tmp[i];
				i++;
			}else{
				nums[k] = tmp[j];
				j++;
				//左边数组，i之后的数都会与j形成逆序对
				count+=(mid+1-i);
			}
		}
		return count;
	}
}
