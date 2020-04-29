package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.MountainArray;
//山脉数组
public class L1095_FindInMountainArray {
	public int findInMountainArray(int target, MountainArray mountainArr) {
		int left =0;
		int right = mountainArr.length()-1;
		while(left<right){
			int mid = (left+right)/2;
			if(mountainArr.get(mid) < mountainArr.get(mid+1)){
				//mid不可能是
				left = mid+1;
			}else{
				//right不是mid-1，因为mid有可能是峰值
				right = mid;
			}
		}
		int peek = left;
		int index = binarySearch(mountainArr,target,0,peek,true);
		if(index != -1) return index;
		return binarySearch(mountainArr,target,peek,mountainArr.length()-1,false);
	}

	public int binarySearch(MountainArray arr,int target,int left,int right,boolean isLeft){
		target = isLeft ? target : -target;
		while(left <= right){
			int mid = (left+right)/2;
			int cur = isLeft?arr.get(mid):-arr.get(mid);
			if(cur == target){
				return mid;
			}else if(cur < target){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return -1;
	}
}
