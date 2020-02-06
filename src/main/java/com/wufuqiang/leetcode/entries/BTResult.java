package com.wufuqiang.leetcode.entries;

import com.wufuqiang.leetcode.entries.BTNode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ author wufuqiang
 **/
@Data
@AllArgsConstructor
public class BTResult {
    private BTNode node;
    private int position;
    private boolean found;
}
