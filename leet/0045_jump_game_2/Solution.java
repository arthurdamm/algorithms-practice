// LeetCode 45. Jump Game II
// https://leetcode.com/problems/jump-game-ii/
// O(n) time, O(1) space
class Solution {
    public int jump(int[] nums) {
        int end = 0, max = 0, jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                jumps++;
                if (end >= nums.length - 1)
                    break;
            }
        }
        return jumps;
    }
}
