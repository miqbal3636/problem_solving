package com.spsoft.leetcode.easy.array;

/* https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/ */

public class L1752CheckIfSortedAndRotated2 {
    //Sliding window approach
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n ==1)
            return true;

        int count=1;

        for(int i=1; i < 2 * n; i++)
        {
            if(nums[i % n] < nums[(i-1) % n]){
                count =1;
            }
            else
                count++;

            if(count == n)
                return true;
        }
        return false;

    }

}
