/*
 * https://leetcode.com/problems/maximum-subarray/
 * O(n^3) Brute Force solution
 * Enumerates all subarrays
 */

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max = INT_MIN, n = nums.size();
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += nums[k];
                if (sum > max) max = sum;
            }
        return max;
    }
};
