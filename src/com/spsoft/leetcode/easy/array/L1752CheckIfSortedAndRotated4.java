package com.spsoft.leetcode.easy.array;

//Problem Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class L1752CheckIfSortedAndRotated4 {

    public boolean check(int[] nums) {
        boolean rotationFound = false;

        for (int i = 0; i < nums.length; i++) {
            int rotationStartIndex = 0;
            if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                //System.out.print(nums[i]);
            } else {
                //System.out.print(nums[i]);

                if (nums[i] < nums[nums.length - 1])
                    return false;

                if (rotationFound) {
                    //System.out.print("rotation found: "+nums[i]);
                    if (i + 1 == nums.length) {
                        for (int j = 0; j <= rotationStartIndex; j++) {
                            if (nums[j] < nums[nums.length - 1])
                                return false;
                        }
                        return true;
                    }
                    return false;
                } else {
                    rotationStartIndex = i + 1;
                    rotationFound = true;
                }
            }
        }
        return true;
    }

}
