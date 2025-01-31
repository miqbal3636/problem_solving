package com.spsoft.hackerrank.medium.graph;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/*
    The time complexity of the Union-Find algorithm with path compression and union by rank is amortized nearly constant time.
    Specifically, it's O(α(n)), where α is the inverse Ackermann function, which grows very slowly.
    However, since we are processing each of the cities array with n elements, the overall time complexity can be considered as O(m α(n)), where m is the number of edges (connections between cities).
    Here's the breakdown:
    Union-Find operations (find and unite): O(α(n)) for each operation.
    Processing all edges: If m is the number of edges, and we perform Union-Find for each, it will be O(m * α(n)).
    Space Complexity: O(n) as we are arrays parent, rank and size all having n.
 */


class Result {

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        DisjointSet ds = new DisjointSet(n);

        // Build one library in each city if the cost of building a library is less than building a road
        if (c_lib <= c_road) {
            return (long) c_lib * n;
        }

        // Process each city connection
        for (List<Integer> edge : cities) {
            ds.unite(edge.get(0), edge.get(1));  // No adjustment needed for 1-based indexing
        }

        // Calculate the number of connected groups and total connected cities
        long numConnectedGroups = ds.numGroupsCount(n);
        long totalConnectedCities = ds.totalConnectedCities;

        // Calculate the number of isolated cities
        long numIsolatedCities = n - totalConnectedCities;

        // Calculate the total cost
        return (long) (numConnectedGroups * c_lib) + (long) (numIsolatedCities * c_lib) + (long) (ds.totalRoads * c_road);
    }

    private static class DisjointSet {
        int[] parent;
        int[] rank;
        int[] size;
        long count = 0;
        long totalRoads = 0;
        long totalConnectedCities = 0;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void unite(int u, int v) {
            int i = find(u);
            int j = find(v);
            if (i == j)
                return;
            if (rank[i] >= rank[j]) {
                parent[j] = i;
                size[i] += size[j];
                if (rank[i] == rank[j])
                    rank[i]++;
            } else {
                parent[i] = j;
                size[j] += size[i];
            }
        }

        long numGroupsCount(int n) {
            for (int i = 1; i <= n; i++) {
                if (parent[i] == i) {
                    count++;
                    totalRoads += size[i] - 1;
                    totalConnectedCities += size[i];
                }
            }
            return count;
        }
    }
}

public class RoadsAndLibraries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
