/*
 * https://leetcode.com/problems/maximum-subarray/
 * O(n^2) Brute Force solution
 * Keeps running sum count
 */

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max = INT_MIN, n = nums.size();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum > max) max = sum;
            }
        }
        return max;
    }
};
