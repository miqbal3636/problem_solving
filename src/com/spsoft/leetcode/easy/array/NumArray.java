package com.spsoft.leetcode.easy.array;
/*
  Leetcode 303: Range Sum Query - Immutable
  Problem Link: https://leetcode.com/problems/range-sum-query-immutable/
 */
class NumArray {
    int runningSum=0;
    int [] prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            runningSum += nums[i];
            prefixSum[i] = runningSum;
        }

    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return prefixSum[right];

        return prefixSum[right] - prefixSum[left -1];

    }
}