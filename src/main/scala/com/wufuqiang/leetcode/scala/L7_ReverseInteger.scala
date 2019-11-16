package com.wufuqiang.leetcode.scala

object L7_ReverseInteger {
  def reverse(x: Int): Int = {
    var result:Int = 0

    if(x < 0)
      try{

        result = 0-  (-x).toString.reverse.toInt
      }catch{
        case e:Exception =>{
          result = 0
        }
      }
    else{
      try{

        result =  x.toString.reverse.toInt
      }catch{
        case e:Exception =>{
          result = 0
        }
      }
    }
    result
  }
}
