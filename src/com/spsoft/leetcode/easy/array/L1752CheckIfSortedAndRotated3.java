package com.spsoft.leetcode.easy.array;

//Problem Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class L1752CheckIfSortedAndRotated3 {

    public boolean check(int[] nums) {
        int i=1;
        while(i < nums.length && nums[i] >= nums[i-1]){
            i++;
        }
        //no rotation found and array is sorted
        if(i== nums.length)
            return true;

        //since rotated first element of array must be greater or equal to the last element of the array
        if(nums[0] < nums[nums.length -1]){
            return false;
        }

        //int rotationIndex =i;
        //i is the rotation index
        int j = i;

        while(j+1 < nums.length){
            if(nums[j+1] < nums[j]){
                return false;
            }
            j++;
        }

        return true;
    }

}
