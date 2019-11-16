package com.wufuqiang.leetcode.scala

class L3_LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    val mapTemp = new scala.collection.mutable.HashMap[Char,Int]
    var length = 0
    import util.control.Breaks._
    var i = 0
    while(i < s.length){
      if(mapTemp.contains(s(i))){
        length = if (length >= mapTemp.size) length else mapTemp.size
        i = mapTemp(s(i)) + 1
        mapTemp.clear()
      }
      mapTemp(s(i)) = i
      i += 1
    }
    length = if (length >= mapTemp.size) length else mapTemp.size
    length
  }

}
