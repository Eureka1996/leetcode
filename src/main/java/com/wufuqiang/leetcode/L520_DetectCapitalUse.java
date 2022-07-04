package com.wufuqiang.leetcode;

/**
 * @ author wufuqiang
 * @ date 2019/12/9/009 - 19:28
 * 
 * 520. 检测大写字母
 * 
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 *
 * 输入：word = "FlaG"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L520_DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if(word.length()<=0){
            return true;
        }
        int upperCount = 0;
        for(int i = 0 ; i < word.length();i++){
            // 判断是否是大写字符
            boolean isUpperCase = Character.isUpperCase(word.charAt(i));
            if(isUpperCase){ // 是大写字符
                upperCount+=1;
                if(upperCount != i+1 ){ // 判断是否全是大写字符
                    return false;
                }
            }else if(upperCount>1){ // 不是大写字符，但大写字符个数超出
                return false;
            }
        }
        return true;
    }
}
