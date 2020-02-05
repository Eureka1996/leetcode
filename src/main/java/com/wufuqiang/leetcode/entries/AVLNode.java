package com.wufuqiang.leetcode.entries;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ author wufuqiang
 **/
@Data
@AllArgsConstructor
public class AVLNode<T extends Comparable> {

    public AVLNode<T> left;
    public AVLNode<T> right;
    public T data;
    public int height;

    public AVLNode(T data){
        this(null,null,data);
    }

    public AVLNode(AVLNode<T> left,AVLNode<T> right,T data){
        this(left,right,data,0);
    }
}
