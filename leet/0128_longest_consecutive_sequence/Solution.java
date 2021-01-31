// LeetCode 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/
// O(n) time-and-space
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> sets = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (sets.containsKey(n))
                continue;
            int left = sets.getOrDefault(n - 1, 0);
            int right = sets.getOrDefault(n + 1, 0);
            int len = left + right + 1;
            sets.put(n - left, len);
            sets.put(n + right, len);
            sets.put(n, len);
            max = Math.max(max, len);
        }
        return max;
    }
}
