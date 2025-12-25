package com.spsoft.interview.medium;

import java.util.*;

public class FindingFriendCircles {
    public static void main(String args[]) {
        List<String> friends = Arrays.asList(
                "YYNN",
                "YYYN",
                "NYYN",
                "NNNY"
        );
        System.out.println("number of friend circles:"+ friendCircles(friends));

    }


    private static int friendCircles(List<String> friends) {
        int n = friends.size();
        boolean [] visited = new boolean[n];
        int count=0;
        for(int i=0; i < n; i++)
        {
            if(!visited[i])
            {
                dfs(friends,visited,i);
                count++;
            }

        }
        return count;
    }

    private static void dfs(List<String> friends, boolean[] visited, int student) {
        visited[student] = true;
        String connectedStudents = friends.get(student);
        for (int j = 0; j < connectedStudents.length(); j++) {
            if (connectedStudents.charAt(j) == 'Y' && !visited[j] && student != j) {
                dfs(friends, visited, j);
            }
        }
    }

}
