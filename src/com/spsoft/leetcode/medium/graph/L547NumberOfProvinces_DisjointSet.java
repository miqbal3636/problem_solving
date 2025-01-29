package com.spsoft.leetcode.medium.graph;

public class L547NumberOfProvinces_DisjointSet {
    DisjointSet ds;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ds = new DisjointSet(n);
        for(int i=0; i < n; i++){
            for(int j=i+1; j < n; j++){
                if(isConnected[i][j] == 1)
                    ds.unite(i, j);
            }
        }
        return ds.getProvinceCount(n);
    }

    private class DisjointSet{
        int n;
        int count=0;
        int [] parent;
        int [] rank;
        public DisjointSet(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void unite(int u, int v){
            int i = find(u);
            int j = find(v);
            if(i == j)
                return;
            if(rank[i] >= rank[j]){
                parent[j] = i;
                if(rank[i] == rank[j])
                    rank[i]++;
            }
            else {
                parent[i] = j;
            }
        }

        int getProvinceCount(int n){
            for(int i= 0; i < n; i++){
                if(parent[i]==i)
                    count++;
            }
            return count;
        }

    }
}
