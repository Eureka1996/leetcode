package com.wufuqiang.leetcode.entries;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ author wufuqiang
 **/
@Data
@AllArgsConstructor
public class BTEntry {
    private Comparable key;
    private Object val;
    private BTNode next;
}
