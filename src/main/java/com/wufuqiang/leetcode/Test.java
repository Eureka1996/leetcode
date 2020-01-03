package com.wufuqiang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 11:09
 **/
public class Test {
    public static void main(String[] args) {
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//        stack.add(1);
//        stack.add(2);
//        stack.addFirst(3);
//        stack.add(4);
//        stack.push(5);
//        System.out.println("poll:"+stack.pollFirst());
//        System.out.println("last:"+stack.pollLast());
//        for(Integer item:stack){
//            System.out.println(item);
//        }
        List<String> list = new ArrayList<String>(3);
//        list.add("wu");
//        list.add("fu");
//        list.add("qiang");
        System.out.println(list);
        list.set(1,"yu");
        System.out.println(list);

    }
}
