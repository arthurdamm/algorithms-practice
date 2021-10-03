// LeetCode 55. Jump Game
// https://leetcode.com/problems/jump-game/
// O(n) time, O(1) space
function canJump(nums: number[]): boolean {
    let maxJump = nums[0];
    for (let i = 1; i <= maxJump && i < nums.length; i++) {
        maxJump = Math.max(maxJump, nums[i] + i);
    }
    return maxJump >= nums.length - 1;
};

