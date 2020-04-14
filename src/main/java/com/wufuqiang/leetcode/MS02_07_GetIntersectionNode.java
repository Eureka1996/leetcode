package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;
//链表相交
public class MS02_07_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while(ha != hb){
            if(ha != null){
                ha = ha.next;
            }else{
                ha = headB;
            }
            if(hb != null){
                hb = hb.next;
            }else{
                hb = headA;
            }
        }
        return ha;

    }
}
