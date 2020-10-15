// LeetCode 213. House Robber II
// O(N) time, O(1) space
class Solution {
    public int _rob(int[] nums, int start, int stop) {
        int inc = nums[start], exc = Math.max(nums[start], nums[start + 1]), temp;
        for (int i = start + 2; i <= stop; i++) {
            temp = exc;
            exc = Math.max(exc, inc + nums[i]);
            inc = temp;
        }
        return exc;
    }
 
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(_rob(nums, 0, nums.length - 2), _rob(nums, 1, nums.length - 1));
    }
}


