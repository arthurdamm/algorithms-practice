// LeetCode 164. Maximum Gap
// https://leetcode.com/problems/maximum-gap/
// O(n) time-and-space
class Solution {
public:
    int maximumGap(vector<int>& nums) {
        radixSort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.size(); i++)
            maxGap = max(maxGap, nums[i] - nums[i - 1]);
        return maxGap;
    }
    
    void radixSort(vector<int>& nums) {
        int maxVal = INT_MIN;
        for (auto n : nums)
            maxVal = max(maxVal, n);
        for (int xp = 1; maxVal / xp; xp *= 10)
            count(nums, xp);   
    }
    
    void count(vector<int>& nums, int xp) {
        vector<int> out(nums.size());
        int count[10] = {0};
        for (auto n : nums)
            count[n / xp % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = nums.size() - 1; i >= 0; i--)
            out[--count[nums[i] / xp % 10]] = nums[i];
        nums = out;
    }
};
