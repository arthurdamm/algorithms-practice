// LeetCode 594. Longest Harmonious Subsequence
// https://leetcode.com/problems/longest-harmonious-subsequence/
// O(n) time, O(n) space
function findLHS(nums: number[]): number {
    let map = new Map(), max = 0;
    for (let n of nums)
        map.set(n, (map.get(n) || 0) + 1);
    for (let n of nums)
        if (map.has(n + 1))
            max = Math.max(max, map.get(n) + map.get(n + 1));
    return max;  
};

// One pass
function findLHS(nums: number[]): number {
    let map = new Map(), max = 0;
    for (let n of nums) {
        map.set(n, (map.get(n)||0) + 1);
        if (map.has(n + 1))
            max = Math.max(max, map.get(n) + map.get(n + 1));
        if (map.has(n - 1))
            max = Math.max(max, map.get(n) + map.get(n - 1));
    }
    return max;  
};
