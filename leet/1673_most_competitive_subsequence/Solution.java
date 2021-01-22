// LeetCode 1673. Find the Most Competitive Subsequence
// https://leetcode.com/problems/find-the-most-competitive-subsequence/
// O(n) time, O(k) space
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int stack[] = new int[k], i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (i > 0 && nums[j] < stack[i - 1] && nums.length - j > k - i)
                i--;
            if (i < k)
                stack[i++] = nums[j];
        }
        return stack;
    }
}
