package com.wufuqiang.leetcode.entries;

import lombok.Data;

/**
 * @ author wufuqiang
 **/
@Data
public class RBNode<T> {
    private T value;
    private boolean isRed;
    private RBNode<T> parent;
    private RBNode<T> left;
    private RBNode<T> right;

}
