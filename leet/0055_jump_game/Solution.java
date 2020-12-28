// LeetCode 55. Jump Game
// https://leetcode.com/problems/jump-game/
// O(n) time, O(1) space
class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, max = 0;
        for (; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1)
                return true;
        }
        return false;
    }
}
