// LeetCode 1306. Jump Game III
// https://leetcode.com/problems/jump-game-iii/
// O(n) time-and-space
function canReach(arr: number[], start: number): boolean {
    const visited = new Array(arr.length).fill(false);
    const dfs = (i: number): boolean => {
        if (i < 0 || i >= arr.length || visited[i]) return false;
        if (arr[i] == 0) return true;
        visited[i] = true;
        return dfs(i + arr[i]) || dfs(i - arr[i]);
    }
    return dfs(start);
};

