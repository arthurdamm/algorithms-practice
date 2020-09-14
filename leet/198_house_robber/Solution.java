// LeetCode 198. House Robber
// O(n) time, O(1) space
class Solution {
    public int rob(int[] nums) {
        int inc = 0, exc = 0, temp;
        for (int num : nums) {
            temp = inc;
            inc = Math.max(inc, exc + num);
            exc = temp;
        }
        return inc;
    }
}

