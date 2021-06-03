package com.wufuqiang.leetcode.mianshiti;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-04 00:25
 */
public class MS01_06_CompressString {
    public static void main(String[] args) {

    }

    public String compressString(String S) {
        if(S.length() <= 1) return S;
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        char pre = S.charAt(0);
        char cur = '0';
        int count = 1;
        sb.append(pre);
        for(int i = 1;i<len;i++ ){
            cur = S.charAt(i);
            if(pre == cur){
                count+=1;
            }else{
                sb.append(count);
                count=1;
                sb.append(cur);
                pre = cur;
            }
        }
        sb.append(count);
        return sb.length() >= len ? S:sb.toString();
    }

}
