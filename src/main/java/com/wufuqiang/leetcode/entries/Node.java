package com.wufuqiang.leetcode.entries;

import java.util.List;

/**
 * @ author wufuqiang
 * @ date 2019/12/22/022 - 10:49
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
