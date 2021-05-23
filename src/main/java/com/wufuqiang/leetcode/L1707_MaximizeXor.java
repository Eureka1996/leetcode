package com.wufuqiang.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Wu Fuqiang
 * @create: 2021-05-23 21:42
 */
public class L1707_MaximizeXor {
    public static void main(String[] args) {

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] newQueries = new int[queries.length][3];
        //标记原来的位置
        for(int i = 0;i<queries.length;i++){
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }

        Arrays.sort(newQueries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] ans = new int[queries.length];

        TrieBinary trie = new TrieBinary();
        int idx  = 0;  //排序后，排序到字典树的索引
        int n = nums.length;
        for(int[] query : newQueries){
            int x = query[0];
            int m = query[1];
            int qid = query[2];
            while(idx < n && nums[idx] <= m){
                trie.insert(nums[idx]);
                ++idx;
            }
            if(idx == 0){
                ans[qid] = -1;
            }else{
                ans[qid] = trie.getMaxXor(x);
            }

        }
        return ans;
    }

}



class TrieBinary{
    private static final int L = 30;
    private TrieBinary[] children = new TrieBinary[2];

    public void insert(int val){
        TrieBinary node = this;
        for(int i = L-1;i>=0;--i){
            int bit = (val>>i) & 1;
            if(node.children[bit] == null){
                node.children[bit] = new TrieBinary();
            }
            node = node.children[bit];
        }
    }

    public int getMaxXor(int val){
        int ans = 0;
        TrieBinary node = this;
        for(int i= L-1;i>=0;--i){
            int bit = (val >> i) &1;
            if(node.children[bit^1] != null){
                ans |= 1<<i;
                bit^=1;
            }
            node = node.children[bit];
        }
        return ans;
    }


}
