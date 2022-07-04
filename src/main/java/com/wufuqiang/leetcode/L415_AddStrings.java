package com.wufuqiang.leetcode;

/**
 * @author Wu Fuqiang
 * @date 2021/11/12 1:03 下午
 */
public class L415_AddStrings {
    public static void main(String[] args) {
        L415_AddStrings l = new L415_AddStrings();
        final String res = l.addStrings("123456", "67890");
        System.out.println(res);
    }
    public String addStrings(String num1, String num2) {
        int n1index = num1.length() -1;
        int n2index = num2.length() -1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        while(n1index >= 0 || n2index >= 0 || add > 0){
            int firstNum = n1index >= 0 ? num1.charAt(n1index)-'0':0;
            int secondNum = n2index >= 0 ? num2.charAt(n2index)-'0':0;
            int res = firstNum+secondNum+add;
            add = res/10;
            sb.append(res%10);
            n1index-=1;
            n2index-=1;
        }
        sb.reverse();
        return sb.toString();
    }
}
