package com.spsoft.leetcode.medium.matrix;
/*
    Leetcode 200: Number of Islands - DFS - BFS
    https://leetcode.com/problems/number-of-islands
 */

import java.util.*;


public class L200NumberOfIslands {
    private static final int[][] moves = {
            {0, -1}, // left
            {0, 1}, // right
            {-1, 0}, // up
            {1, 0} // down
    };

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    //dfs(grid,i,j,m,n);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if ((i < 0 || i >= m) || (j < 0 || j >= n))
            return;
        if (grid[i][j] == '0')
            return;
        // mark as visited
        grid[i][j] = '0';

        for (int[] move : moves) {
            dfs(grid, i + move[0], j + move[1], m, n);
        }
    }

    private void bfs(char[][] grid, int i, int j, int m, int n) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0'; // mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] move : moves) {
                int x1 = x + move[0];
                int y1 = y + move[1];
                if ((x1 >= 0 && x1 < m) && (y1 >= 0 && y1 < n) && grid[x1][y1] == '1') {
                    queue.add(new int[]{x1, y1});
                    grid[x1][y1] = '0'; // mark as visited

                }

            }

        }
    }
}

