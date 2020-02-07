package com.wufuqiang.leetcode.tree;

import com.wufuqiang.leetcode.entries.BTNode;
import com.wufuqiang.leetcode.entries.BTResult;

/**
 * @ author wufuqiang
 **/
public class BTree<K extends Comparable<K>> {
    private BTNode root;
    private int order;

    /**
     *
     * @param key
     * @return
     */
    public BTResult search(K key){
        BTNode preNode = null;
        BTNode node = root;
        boolean found = false;
        int i = 0;
        while(node != null && !found){
            i = index(node,key);
            if(node.getKey(i).equals(key)){
                found = true;
            }else{
                preNode = node;
                node = node.getChild(i);
            }
        }
        return new BTResult(found?node:preNode,i,found);
    }

    public void insert(K key){
        BTResult result = search(key);
        BTNode<K> node = result.getNode();
        int positionn = result.getPosition();
        K k = key;
        BTNode<K> rightNode = null;
        while(node != null){


        }


    }


    /**
     * 根据给定key，从对应的node中寻找出第一个大于给定key的index
     * @param node
     * @param key
     * @return
     */
    private int index(BTNode<K> node,K key){
        for(int i = 0 ;i < node.getKeyCount();i++){
            if(key.compareTo(node.getKey(i)) <= 0){
                return i;
            }
        }
        return node.getKeyCount();
    }
}
