/*
 * https://leetcode.com/problems/maximum-subarray/
 * O(n) Kadane's Algorithm
 * Keeps running sum count as long as > 0
 *
 * Pointers are faster than iterators or indexes.
 */

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max = INT_MIN, sum = 0;
        for (int *i = &nums[0], *n = &*nums.end(); i != n; i++) {
            if (sum <= 0)
                sum = *i;
            else
                sum += *i;
            if (sum > max) max = sum;
        }
        return max;
    }
};