package com.spsoft.leetcode.medium.graph;

import java.util.*;

public class L547NumberOfProvinces_DFS_BFS {
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, n, isConnected);
                //bfs(i, n, isConnected);
            }
        }
        return count;
    }

    void dfs(int i, int n, int[][] isConnected) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(j, n, isConnected);
            }
        }
    }

    void bfs(int city, int n, int[][] isConnected) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[city] = true;
        q.offer(city);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && isConnected[u][v] == 1) {
                    visited[v] = true;
                    q.offer(v);
                }
            }

        }
    }
}
