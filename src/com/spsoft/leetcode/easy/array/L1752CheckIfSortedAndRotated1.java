package com.spsoft.leetcode.easy.array;

/* Problem Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/ */

public class L1752CheckIfSortedAndRotated1 {
    //O(n) sliding window approach with extra 2n space.
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n ==1)
            return true;

        int[] extendedArray = new int[2 * n];

        // Copy the array elements twice
        for (int i = 0; i < n; i++) {
            extendedArray[i] = nums[i];
            extendedArray[i + n] = nums[i];
        }

        // Check for a contiguous sorted subarray of length n
        int count = 1;
        for (int i = 1; i < 2 * n; i++) {
            if (extendedArray[i] >= extendedArray[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == n) {
                return true;
            }
        }

        return false;
    }

}
