// LeetCode 1340. Jump Game V
// https://leetcode.com/problems/jump-game-v/
// O(n^2) time O(n) space
class Solution {
    int[] dp, arr;
    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        this.arr = arr;
        for (int i = 0; i < arr.length; i++)
            if (dp[i] == 0)
                dfs(i, d);
        int max = 0;
        for (int n : dp)
            max = Math.max(max, n);
        return max;
    }
    int dfs(int i, int d) {
        dp[i] = 1;
        int end = Math.max(0, i - d);
        for (int j = i - 1; j >= end && arr[i] > arr[j]; j--)
            dp[i] = Math.max(dp[i], (dp[j] > 0 ? dp[j] : dfs(j, d)) + 1);
        end = Math.min(arr.length - 1, i + d);
        for (int j = i + 1; j <= end && arr[i] > arr[j]; j++)
            dp[i] = Math.max(dp[i], (dp[j] > 0 ? dp[j] : dfs(j, d)) + 1);
        return dp[i];
    }   
}
