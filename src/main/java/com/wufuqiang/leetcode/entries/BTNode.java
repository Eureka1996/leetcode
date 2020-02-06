package com.wufuqiang.leetcode.entries;

import lombok.Data;

import java.util.List;

/**
 * @ author wufuqiang
 **/
@Data
public class BTNode<K extends Comparable> {
    private int keyCount = 0;
    private List<K> keys;
    private List<BTNode> children;

    public K getKey(int index){
        return this.keys.get(index);
    }

    public BTNode getChild(int index){
        return this.children.get(index);
    }
}
