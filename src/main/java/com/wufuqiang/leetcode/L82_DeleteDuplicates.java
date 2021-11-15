package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.ListNode;

/**
 * @author Wu Fuqiang
 * @date 2021/11/15 10:23 下午
 * 
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 */
public class L82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode pHead) {
        if(pHead == null) return null;
        // 哨兵节点，方便插入和最后结果的返回
        ListNode head = new ListNode(Integer.MIN_VALUE);
        // 结果链表的最后一个节点
        ListNode tail = head;
        // 当前节点
        ListNode curNode = pHead;
        // 下一个节点
        ListNode nextNode = pHead.next;
        
        // 不需要这样的判断
        // if(nextNode == null) return pHead;
        
        // 记录重复值的长度
        int count = 0;

        while(nextNode != null){
            if(curNode.val != nextNode.val){
                if(count == 0){ // 重复的元素的个数为0时，才有资格放入到结果节点中。
                    tail.next = curNode;
                    tail = curNode;

                }
                curNode = nextNode;
                nextNode = nextNode.next;
                tail.next = null;
                count = 0;
            }else{
                count+=1;
                nextNode = nextNode.next;
            }
        }
        
        if(count == 0){
            tail.next = curNode;
        }
        
        return head.next;
    }
}
