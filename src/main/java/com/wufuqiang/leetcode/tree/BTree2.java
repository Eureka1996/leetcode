package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.BTEntry;
import com.wufuqiang.leetcode.entries.BTNode2;

import java.util.List;

/**
 * @ author wufuqiang
 **/
public class BTree2<Key extends Comparable<Key>,Value> {
    private int M = 4;
    private BTNode2 root ;
    private int height;
    private int n;

    public BTree2(){
        this.root = new BTNode2(0);
    }

    public int size(){
        return this.n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int height(){
        return this.height;
    }

    public Value get(Key key){
        if(key == null){
            throw new NullPointerException("key must not be null");
        }
        return search(root,key,height);
    }

    private Value search(BTNode2 root , Key key,int ht){

        List<BTEntry> children = root.getChildren();

        if(ht == 0){
            for(int i = 0;i < children.size();i++ ){
                if(key.equals(children.get(i).getKey())){
                    return (Value)children.get(i).getVal();
                }
            }
        }else{

        }
        return null;

    }
}
