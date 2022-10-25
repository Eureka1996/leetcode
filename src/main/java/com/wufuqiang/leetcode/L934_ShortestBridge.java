package com.wufuqiang.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Wu Fuqiang
 * @create: 2022-10-25 08:37
 */
public class L934_ShortestBridge {
    public static void main(String[] args) {

    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        // 记录填补的方向
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<int[]>();
        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    // 将遍历过的修改为-1
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        island.add(cell);
                        // 向4个方向延伸
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            // 没有超出边界，且还是岛屿
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                // 放入到岛屿队列中
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] cell : island) {
                        queue.offer(cell);
                    }
                    int step = 0;
                    while (!queue.isEmpty()) {
                        // 每一次while循环是向外延伸一次
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        // 将最外围加入到队列中
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {  // 找到了另外一个岛屿
                                        return step;
                                    }
                                }
                            }
                        }
                        // 每一次向外延伸都要加一个距离
                        step++;
                    }
                }
            }
        }
        return 0;
    }

}
