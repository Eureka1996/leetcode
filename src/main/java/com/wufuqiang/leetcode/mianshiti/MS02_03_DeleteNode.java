package com.wufuqiang.leetcode.mianshiti;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-22 10:37
 */
public class MS02_03_DeleteNode {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
