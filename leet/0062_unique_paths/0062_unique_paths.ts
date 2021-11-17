// LeetCode 62. Unique Paths
// https://leetcode.com/problems/unique-paths/
// O(m*n) time and space
function uniquePaths(m: number, n: number): number {
    const dp = Array(m).fill(0).map(() => Array(n).fill(0));
    dp[0][0] = 1;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i > 0)
                dp[i][j] += dp[i - 1][j];
            if (j > 0)
                dp[i][j] += dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
}
