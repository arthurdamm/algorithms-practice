// LeetCode 1463. Cherry Pickup II
// https://leetcode.com/problems/cherry-pickup-ii/
// O(m*n^2) time-and-space
var cherryPickup = function(grid) {
    dp = Array(grid.length).fill(0).
        map(a => Array(grid[0].length).fill(0)
            .map(b => Array(grid[0].length).fill(-1)));
    function dfs(r, c1, c2) {
        if (dp[r][c1][c2] > -1)
            return dp[r][c1][c2];
        dp[r][c1][c2] = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        let nextVal = 0;
        for (let dc1 = c1 - 1; dc1 <= c1 + 1; dc1++) {
            for (let dc2 = c2 - 1; dc2 <= c2 + 1; dc2++) {
                if (r + 1 == grid.length || dc1 < 0 || dc2 < 0 ||
                    dc1 == grid[0].length || dc2 == grid[0].length)
                    continue;
                nextVal = Math.max(nextVal, dfs(r + 1, dc1, dc2));
            }
        }
        return dp[r][c1][c2] += nextVal;
    }
    return dfs(0, 0, grid[0].length - 1);
};
