// LeetCode 695. Max Area of Island
// https://leetcode.com/problems/max-area-of-island/
// O(n * m) time, O(n * m) space
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                maxArea = Math.max(maxArea, dfs(i, j, grid));
        return maxArea;
    }
    
    private int dfs(int i, int j, int[][] grid) {
        if (grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        return 1 + (i > 0 ? dfs(i - 1, j, grid) : 0)
                 + (i < grid.length - 1 ? dfs(i + 1, j, grid) : 0)
                 + (j > 0 ? dfs(i, j - 1, grid) : 0)
                 + (j < grid[i].length - 1 ? dfs(i, j + 1, grid) : 0);
    }
}
