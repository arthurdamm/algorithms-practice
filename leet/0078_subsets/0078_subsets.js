/*
LeetCode 78. Subsets
https://leetcode.com/problems/subsets/
O(n*2^n) time-and-space
Key Insight: Pass index in array recursively, 0/1 at each iteration
*/
var subsets = function(nums) {
    const solutions = []
    function dfs(i, subset) {
        if (i === nums.length) {
            solutions.push([...subset]);
            return;
        }
        dfs(i + 1, subset);
        subset.push(nums[i]);
        dfs(i + 1, subset);
        subset.pop();
    }
    dfs(0, []);
    return solutions;
};
