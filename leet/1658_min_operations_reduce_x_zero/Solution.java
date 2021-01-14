// LeetCode 1658. Minimum Operations to Reduce X to Zero
// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
// O(n) time O(1) space
class Solution {
    public int minOperations(int[] nums, int x) {
        int targetSum = -x, maxSubarray = 0;
        for (int num : nums)
            targetSum += num;
        if (targetSum <= 0)
            return targetSum < 0 ? -1 : nums.length;
        for (int i = 0, j = 0; j < nums.length; j++) {
            targetSum -= nums[j];
            while (targetSum < 0)
                targetSum += nums[i++];
            if (targetSum == 0)
                maxSubarray = Math.max(maxSubarray, j - i + 1);
        }
        return maxSubarray == 0 ? -1 : nums.length - maxSubarray;
    }
}
