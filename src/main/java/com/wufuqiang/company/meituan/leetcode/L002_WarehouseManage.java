package com.wufuqiang.company.meituan.leetcode;

import java.io.*;
import java.util.Scanner;

/**
 * @author Wu Fuqiang
 * @date 2021/11/7 11:08 上午
 * 
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，
 * 每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。
 * 已知货物入库的时候是按顺序堆放在一起的。
 * 如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 * 已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,
 * 小美会根据单据依次不放回的取出货物。请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 *
 * 格式：
 *
 *
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示货物的数量。
 * - 输入第二行包含 n 个正整数，表示 1~n 号货物的重量 w[i] 。
 * - 输入第三行有 n 个数，表示小美按顺序取出的货物的编号，也就是一个 1~n 的全排列。
 * 输出：
 * - 输出包含 n 行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
 * 示例：
 *
 *
 * 输入：
 *      5
 *      3 2 4 4 5 
 *      4 3 5 2 1
 * 输出：
 *      9
 *      5
 *      5
 *      3
 *      0
 * 解释：
 * 原本的状态是 {{3,2,4,4,5}} ，取出 4 号货物后，得到 {{3,2,4},{5}} ，
 * 第一堆货物的和是 9 ，然后取出 3 号货物得到 {{3,2}{5}} ，此时第一堆和第二堆的和都是 5 ，以此类推。
 * 提示：
 *
 * 1 <= n <= 50000
 * 1 <= w[i] <= 100
 * 请注意，本题需要自行编写「标准输入」和「标准输出」逻辑，以及自行 import/include 需要的 library。了解书写规则
 *
 */
public class L002_WarehouseManage {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 读取货物数量
        int n = Integer.parseInt(sc.nextLine());
        // 存放货物重量，从index=1开始存放
        int[] arr = new int[n + 1];
        // 前缀和
        int[] prev = new int[n + 1];
        String[] w = sc.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(w[i - 1]);
            prev[i] += prev[i - 1] + arr[i];
        }
        // 存放每堆货物的左右边界下标
        int[][] d = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            d[i] = new int[]{-1,-1};//将d数组值初始化为-1,便于判断空位置
        }

        int[] res = new int[n];//存储结果的数组

        int maxW = 0;
        String[] q = sc.nextLine().split(" ");
        for (int i = n - 1; i >= 0; i--) {
            int x = Integer.parseInt(q[i]);
            res[i] = maxW;
            if(i == 0) break;
            //更新最大重量
            int cur = arr[x];
            int left = x, right = x;//左边界和右边界,注意如果左右无连通区域则区间为[x,x],所以初始化为x
            //每次只会将左右两块区域连成一块,我们只需关心一段区间的左边界和右边界,就能通过前缀和数组查询到区间和
            if(x + 1 <= n && d[x + 1][0] != -1){
                cur += prev[d[x + 1][1]] - prev[d[x + 1][0] - 1];
                right = d[x + 1][1]; //更新右边界
            }
            if(x - 1 > 0 && d[x - 1][1] != -1){
                cur += prev[d[x - 1][1]] - prev[d[x - 1][0] - 1];
                left = d[x - 1][0]; //更新左边界
            }

            maxW = Math.max(maxW, cur);
            //更新两端点的左右区间
            d[left][0] = left;
            d[left][1] = right;
            d[right][0] = left;
            d[right][1] = right;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]+"\n");
        }

        sc.close();
    }
}
