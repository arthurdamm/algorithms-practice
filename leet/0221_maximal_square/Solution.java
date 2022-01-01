// LeetCode 221. Maximal Square
// https://leetcode.com/problems/maximal-square/
// O(m*n) time-and-space
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '0') {
                    dp[row][col] = 0;
                } else if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col - 1],
                                           dp[row - 1][col]),
                                           dp[row][col - 1]) + 1;
                }
                maxSquare = Math.max(maxSquare, dp[row][col] * dp[row][col]);
            }
        }
        return maxSquare;
    }
}
