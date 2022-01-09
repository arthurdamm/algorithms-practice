// LeetCode 1463. Cherry Pickup II
// https://leetcode.com/problems/cherry-pickup-ii/
// O(m*n^2) time & space
class Solution {
public:
    vector<vector<vector<int>>> dp;
    
    int cherryPickup(vector<vector<int>>& grid) {
        dp.resize(grid.size(),
                  vector<vector<int>>(grid[0].size(), vector<int>(grid[0].size(), -1)));
        return dfs(grid, 0, 0, grid[0].size() - 1);
    }
    
    private: int dfs(vector<vector<int>>& grid, size_t row, size_t col1, size_t col2) {
        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        dp[row][col1][col2] = grid[row][col1] + grid[row][col2];
        int maxVal = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextCol1 = col1 + i;
                int nextCol2 = col2 + j;
                if (row + 1 < grid.size() && nextCol1 != nextCol2 &&
                   nextCol1 >= 0 && nextCol2 >= 0 &&
                   nextCol1 < grid[0].size() && nextCol2 < grid[0].size())
                    maxVal = max(maxVal, dfs(grid, row + 1, nextCol1, nextCol2));
            }
        }
        return dp[row][col1][col2] += maxVal;
    }
};
