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

    public RBNode(){}
    public RBNode(T value){this.value=value;}
    public RBNode(T value,boolean isRed){this.value=value;this.isRed = isRed;}

    public void makeBlack(){
        this.isRed = false;
    }
    public void makeRed(){
        this.isRed = true;
    }

    public boolean isBlack(){
        return !isRed;
    }

}
