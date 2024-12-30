/*
 https://leetcode.com/problems/group-anagrams/
*/

package com.spsoft.leetcode.medium.hashmap;

import java.util.*;

public class L49AnagramGrouper {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char ch[] = str.toCharArray();

            Arrays.sort(ch);

            String key = new String(ch);

            map.computeIfAbsent(key, l -> new ArrayList<>()).add(str);

        }

        return new ArrayList<>(map.values());
    }
}