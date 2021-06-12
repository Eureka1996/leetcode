package com.wufuqiang.leetcode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-13 00:17
 */
public class L278_FirstBadVersion {
    public static void main(String[] args) {

    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersion(1,n);
    }

    public int firstBadVersion(int low,int hight){
        if(low == hight) return low;
        int mid = low+(hight-low)/2;//防止计算时溢出
        if(isBadVersion(mid)){
            return firstBadVersion(low,mid);
        }else{
            return firstBadVersion(mid+1,hight);
        }
    }
}
