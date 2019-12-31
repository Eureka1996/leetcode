package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 **/
public class L414_ThirdMax {

    public int kthMax(int[] nums,int low,int hight,int k){

        if(low < hight){
            int q = partition(nums,0,hight);
            if(q==k){
                return nums[q];
            }else if(q>k){
                return kthMax(nums,low,q-1,k);
            }else{
                return kthMax(nums,q+1,hight,k);
            }
        }
        return nums[0];
    }

    public int partition(int A[],int low,int hight){
        int i = low-1;
        int x = A[hight];
        for(int j = 0;j<hight;j++){
            if(A[j] < x){
                i+=1;
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        int tmp = A[i+1];
        A[i+1] = A[hight];
        A[hight] = tmp;
        return i+1;
    }

    public int thirdMax(int[] nums) {
        int[] result = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] > result[0]){
                count+=1;
                result[2] = result[1];
                result[1] = result[0];
                result[0] = nums[i];
            }else if(nums[i] < result[0] && nums[i] > result[1]){
                count+=1;
                result[2] = result[1];
                result[1] = nums[i];
            }else if(nums[i] < result[1] && nums[i] > result[2]){
                count+=1;
                result[2] = nums[i];
            }
        }
        if(count < 3){
            return result[0];
        }else{
            return result[2];
        }

    }
}
