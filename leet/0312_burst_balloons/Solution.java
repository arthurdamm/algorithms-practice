// LeetCode 312. Burst Balloons
// https://leetcode.com/problems/burst-balloons/
// O(n^3) time, O(n^2) space
class Solution {
    int[][] dp;
    int[] nums;
    
    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        this.nums = nums;
        return dfs(0, nums.length - 1);
        
    }
    
    private int dfs(int l, int r) {
        if (l > r)
            return 0;
        if (dp[l][r] > 0)
            return dp[l][r];
        for (int i = l; i <= r; i++) {
            int coins = ( l - 1 >= 0 ? nums[l - 1] : 1) * nums[i] *
                (r + 1 < nums.length ? nums[r + 1] : 1);
            coins += dfs(l, i - 1) + dfs(i + 1, r);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
