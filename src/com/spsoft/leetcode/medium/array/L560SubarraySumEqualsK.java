/*
    Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/
 */

package com.spsoft.leetcode.medium.array;

import java.util.*;

public class L560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        int count = 0;

        int sum = 0;

        prefixSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}

/*
Here's a short note on the `subarraySum` function:

This function aims to find the number of continuous subarrays within the given array `nums` that sum up to a specified value `k`. The approach leverages a prefix sum and a hash map to keep track of the cumulative sums encountered so far and their frequencies.

Here's a brief step-by-step explanation:

1. **Initialize HashMap**: `prefixSum` keeps track of the cumulative sums and their frequencies.
2. **Initialize Variables**: `count` (to store the number of subarrays) and `sum` (to store the running sum) are initialized to 0.
3. **Base Case**: `prefixSum.put(0, 1)` is used to handle the case where the sum of the subarray itself is equal to `k`.
4. **Iterate Through Array**: For each element in `nums`, the function:
    - Adds the element to `sum`.
    - Checks if `sum - k` is present in `prefixSum`. If it is, it means there is a subarray ending at the current index that sums to `k`. The count of such subarrays is added to `count`.
    - Updates `prefixSum` with the current `sum` and its frequency.
5. **Return Result**: Finally, `count` is returned, which represents the number of subarrays whose sum equals `k`.

In essence, this function efficiently finds the desired subarrays using the prefix sum technique and a hash map, with a time complexity of O(n). This avoids the need for nested loops, making the solution both elegant and performant.
 */