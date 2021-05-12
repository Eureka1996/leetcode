package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-12 22:25
 */
public class L166_FractionToDecimal {
    public static void main(String[] args) {

    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator ^ denominator) >>> 31 == 1){
            sb.append("-");
        }
        long numeratorLong = Math.abs(Long.valueOf(numerator));
        long denominatorLong = Math.abs(Long.valueOf(denominator));


        long s = numeratorLong/denominatorLong;
        sb.append(s);
        long carry = numeratorLong % denominatorLong;
        if(carry>0){
            sb.append(".");
            int begin = sb.length();
            int position = 0;
            int startPosition = -1;
            Map<Long,Integer> map = new HashMap<>();
            map.put(carry,position);
            while(carry > 0){
                carry = carry*10;
                sb.append(carry/denominatorLong);
                carry %= denominatorLong;
                if(map.containsKey(carry)){
                    startPosition = map.get(carry);
                    break;
                }else{
                    position++;
                    map.put(carry,position);
                }
            }
            if(carry>0){
                sb.insert(begin+startPosition,"(");
                sb.append(")");
            }

        }

        return sb.toString();
    }
}
