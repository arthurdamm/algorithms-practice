// LeetCode 1413. Minimum Value to Get Positive Step by Step Sum
// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
// O(n) time, O(1) space
function minStartValue(nums: number[]): number {
    let sum = 0, startingVal = 1;
    for (const num of nums) {
        sum += num;
        startingVal = Math.max(startingVal, sum < 0 ? 1 - sum : 1);
    }
    return startingVal;
};
