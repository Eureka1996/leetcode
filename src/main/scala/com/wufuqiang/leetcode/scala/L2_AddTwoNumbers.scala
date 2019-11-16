package com.wufuqiang.leetcode.scala

object L2_AddTwoNumbers {

  def compute(node1: ListNode, node2: ListNode ,result :ListNode):Unit={
    var tmp = node1.x + node2.x
    result.next = new ListNode(tmp % 10)
    if(node1.next == null && node2.next == null && tmp / 10 ==0){
      return
    }
    var node1Next = if(node1.next != null) node1.next else new ListNode(0)
    var node2Next = if(node2.next != null) node2.next else new ListNode(0)
    node1Next.x += tmp /10
    compute(node1Next,node2Next,result.next)
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var result = new ListNode
    compute(l1,l2,result)
    result.next
  }
}


//   Definition for singly-linked list.
 class ListNode(var _x: Int = 0) {
   var next: ListNode = null
   var x: Int = _x
 }


/**
  * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and
  * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  *
  * /

