package com.wufuqiang.leetcode.entries;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author wufuqiang
 **/
@Data
public class BTNode2 {
    //节点孩子的数量
    private int childCount;
    private List<BTEntry> children = new ArrayList<BTEntry>();
    public BTNode2(int childCount){
        this.childCount = childCount;
    }
}
