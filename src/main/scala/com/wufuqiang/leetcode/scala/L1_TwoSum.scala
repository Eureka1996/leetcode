package com.wufuqiang.leetcode.scala

object L1_TwoSum {
  /**
    * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    * You may assume that each input would have exactly one solution, and you may not use the same element twice.
    *
    * */
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {

      val result = new Array[Int](2)
      val numMap = new scala.collection.mutable.HashMap[Int,Int]
      var i = 0
      import util.control.Breaks._
      breakable{
        for(num <- nums ){
          val targetTemp = target - num
          if(numMap.contains(targetTemp) ){
            result(0) = numMap(targetTemp)
            result(1) = i
            break()
          }
          numMap.put(num,i)
          i+=1
        }
      }


      result

    }

}
