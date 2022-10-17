package com.wufuqiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-13 14:36
 *
 * 水果成篮
 *
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 *
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L904_TotalFruit {
    public static void main(String[] args) {

    }

    public int totalFruit1(int[] tree) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        int resultTmp = 0;
        for(int i = 0;i<tree.length;i++){
            if(map.containsKey(tree[endIndex])){
                Integer integer = map.get(tree[endIndex]);
                integer++;
                map.put(tree[endIndex],integer);
                resultTmp++;
            }else{
                if(map.size() >=2){
                    result = Math.max(result,resultTmp);
                    resultTmp = 0;
                    int mapVal = map.get(tree[startIndex]);
                    while(mapVal > 0){
                        mapVal--;
                        map.put(tree[startIndex],mapVal);
                        startIndex++;
                        mapVal = map.get(tree[startIndex]);
                    }
                    map.remove(tree[startIndex]);
                }
                map.put(tree[endIndex],1);
                resultTmp++;
            }
            endIndex++;
        }
        return result;
    }
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> cnt = new HashMap<>();
        int n = fruits.length;
        int left = 0;
        int ans = 0;
        for(int right = 0;right < n;right++){
            cnt.put(fruits[right],cnt.getOrDefault(fruits[right],0)+1);
            while (cnt.size() > 2){
                cnt.put(fruits[left],cnt.getOrDefault(fruits[left],0)-1);
                if(cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left+=1;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

}
