// LeetCode 312. Burst Balloons
// https://leetcode.com/problems/burst-balloons/
// O(n^3) time, O(n^2) space
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        vector<vector<int>> dp;
        dp.resize(nums.size(), vector<int>(nums.size()));
        return dfs(nums, dp, 0, nums.size() - 1);
    }
    
    int dfs(vector<int>& nums, vector<vector<int>>& dp, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r]) return dp[l][r];
        for (int i = l; i <= r; i++) {
            int coins = (l - 1 >= 0 ? nums[l - 1] : 1) * nums[i] *
                (r + 1 < nums.size() ? nums[r + 1] : 1);
            coins += dfs(nums, dp, l, i - 1) + dfs(nums, dp, i + 1, r);
            dp[l][r] = max(dp[l][r], coins);
        }
        return dp[l][r];
    }
};
