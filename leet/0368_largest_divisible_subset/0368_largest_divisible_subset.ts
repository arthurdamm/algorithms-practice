// LeetCode 368. Largest Divisible Subset
// https://leetcode.com/problems/largest-divisible-subset/
// O(n^2) time and space
function largestDivisibleSubset(nums: number[]): number[] {
    nums.sort((a,b) => a - b);
    const dp = Array(nums.length).fill(0).map((a, i) => [nums[i]]);
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] % nums[j] === 0 && dp[j].length > dp[i].length - 1)
                dp[i] = [...dp[j], nums[i]];
        }
    }
    let max = [];
    for (const arr of dp)
        if (arr.length > max.length)
            max = arr;
    return max;
};
