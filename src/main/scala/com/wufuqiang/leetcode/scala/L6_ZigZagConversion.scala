package com.wufuqiang.leetcode.scala

class L6_ZigZagConversion {
  def convert(s: String, numRows: Int): String = {
    var hashMap = new scala.collection.mutable.HashMap[Int,scala.collection.mutable.ArrayBuffer[Char]]()
    var flag = true
    var line = 1
    var str = ""

    if(numRows==1)
      return s

    for(i <- 1 to numRows){
      hashMap(i) = new scala.collection.mutable.ArrayBuffer[Char]()
    }

    for(c <- s){

      hashMap(line).append(c)
      if(line == numRows){
        flag = false
      }
      if(line == 1)
        flag = true

      if(flag){
        line += 1
      }else{
        line -= 1
      }

    }

    for(i <- 1 to numRows){
      str += hashMap(i).mkString("")
    }

    str
  }

}
