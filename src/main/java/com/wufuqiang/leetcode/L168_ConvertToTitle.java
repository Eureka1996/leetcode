package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author wufuqiang
 **/
public class L168_ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0)
        {
            int reminder = n % 26;
            if (reminder == 0)
            {
                reminder = 26;
                n -= 1;
            }
            sb.insert(0, (char)('A' + reminder - 1));
            n /= 26;
        }
        return sb.toString();
    }
}
