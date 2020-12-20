// LeetCode 1463. Cherry Pickup II
// O(m*n^2) time & space
class Solution {
    int[][] grid;
    int[][][] dp;
    int n = 0, m = 0;
    
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][n];
        this.grid = grid;
        return topDown(0, 0, n - 1);
    }
    
    int topDown(int i, int j, int k) {
        if (j < 0 || j >= n || k < 0 || k >= n || j == k)
            return Integer.MIN_VALUE;
        if (dp[i][j][k] > 0)
            return dp[i][j][k];
        int max = 0, result = grid[i][j] + grid[i][k];
        if (i == m - 1)
            return result;
        for (int j2 = j - 1; j2 <= j + 1; j2++) {
            for (int k2 = k - 1; k2 <= k + 1; k2++) {
                max = Math.max(max, topDown(i + 1, j2, k2));
            }
        }
        dp[i][j][k] = result += max;
        return result;
    }
}
