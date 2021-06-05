package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-05 13:07
 */
public class L203_RemoveElements {
    public static void main(String[] args) {

    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode cur = head;
        while(cur != null){

            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = prev.next;
            }
            cur = cur.next;
        }

        return newHead.next;
    }
}
