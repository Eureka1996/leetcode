package com.wufuqiang.leetcode;

public class MS17_10_MajorityElement {
	public int majorityElement(int[] nums) {
		if(nums==null || nums.length ==0){
			return -1;
		}
		int major = 0;
		int cnt = 0;
		for(int num : nums){
			if(cnt == 0){
				major=num;
				cnt = 1;
			}else{
				if(major == num){
					cnt+=1;
				}else{
					cnt-=1;
				}
			}
		}
		int count = 0;
		int halfCount = nums.length/2+1;
		for(int num : nums){
			if(num == major){
				count+=1;
			}
			if(count >= halfCount){
				return major;
			}
		}
		return -1;

	}
}
