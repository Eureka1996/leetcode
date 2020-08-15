package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * 搜索旋转排序数组，无重复元素
 **/
public class L33_Search {

    /**
     *
     * @param nums 被搜索的数组
     * @param low 数组的最底位
     * @param high 数组的最高位
     * @param target 目标值
     * @return
     */
    public int searchRec(int[] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        //获取中间的索引
        int mid = (low+high)/2;
        //如果中间结果等于目标值，返回中间索引
        if(target == nums[mid]){
            return mid;
        }
        //若nums[low] <= nums[mid]，则左边是有序的，转折点在右边
        if(nums[low] <= nums[mid]){
            //注意nums[low] <= target
            if(nums[low] <= target && target < nums[mid]){
                return searchRec(nums,low,mid-1,target);
            }else{
                return searchRec(nums,mid+1,high,target);
            }
        }else{
            //右边是有序的，转折点在左边
            if(nums[mid] < target && target <= nums[high]){
                return searchRec(nums,mid+1,high,target);
            }else{
                return searchRec(nums,low,mid-1,target);
            }
        }
    }

    public int search(int[] nums, int target) {
        return searchRec(nums,0,nums.length-1,target);
    }

    public static void main(String[] args) {
        L33_Search l = new L33_Search();
        System.out.println(l.search(new int[]{2,5,6,0,0,1,2},0));
    }
}
