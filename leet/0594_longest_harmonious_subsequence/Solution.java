// LeetCode 594. Longest Harmonious Subsequence
// https://leetcode.com/problems/longest-harmonious-subsequence/
// O(n) time, O(n) space
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);
        for (var e : count.entrySet())
            if (count.containsKey(e.getKey() + 1))
                max = Math.max(max, e.getValue() +
                               count.get(e.getKey() + 1));
        return max;
    }
}
