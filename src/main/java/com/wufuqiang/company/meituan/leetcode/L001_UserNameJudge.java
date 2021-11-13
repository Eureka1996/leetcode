package com.wufuqiang.company.meituan.leetcode;

import java.util.Scanner;

/**
 * @author Wu Fuqiang
 * @date 2021/11/7 10:09 上午
 * 
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 *
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 * 格式：
 *
 *
 * 输入：
 * - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
 * - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * 输出：
 * - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
 * 示例：
 *
 *
 * 输入：
 *      5
 *      Ooook
 *      Hhhh666
 *      ABCD
 *      Meituan
 *      6666
 * 输出：
 *      Wrong
 *      Accept
 *      Wrong
 *      Wrong
 *      Wrong
 *      
 * 提示：
 *
 * 1 <= T <= 100
 * s 的长度不超过 20
 * 请注意，本题需要自行编写「标准输入」和「标准输出」逻辑，以及自行 import/include 需要的 library。了解书写规则
 * 
 */
public class L001_UserNameJudge {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final int userCnt = Integer.parseInt(sc.nextLine());
        for(int cnt = 0;cnt<userCnt;cnt++){
            String userName = sc.nextLine();
            boolean accept = false;
            int numCount = 0;
            char firstChar = userName.charAt(0);
            
            if((firstChar >= 'A' && firstChar <= 'Z' ) ||
               (firstChar >= 'a' && firstChar <= 'z')){
                accept = true;
            }
            if(userName.length() < 2){
                accept = false;
            }
            
            if(accept){
                for(int i = 1;i<userName.length();i++){
                    firstChar = userName.charAt(i);
                    if((firstChar >= 'A' && firstChar <= 'Z' ) ||
                            (firstChar >= 'a' && firstChar <= 'z')){
                        
                    }else if(firstChar >= '0' && firstChar <= '9'){
                        numCount +=1;
                    }else{
                        accept = false;
                        break;
                    }
                }
            }
            if(accept && numCount > 0){
                System.out.println("Accept");
            }else{
                System.out.println("Wrong");
            }
        }
        sc.close();
    }
}
