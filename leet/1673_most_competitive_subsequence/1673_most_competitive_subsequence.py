# LeetCode 1673. Find the Most Competitive Subsequence
# https://leetcode.com/problems/find-the-most-competitive-subsequence/
# O(n) time, O(k) space
class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        stack = []
        for i in range(len(nums)):
            while stack and nums[i] < stack[-1] and len(nums) - i > k - len(stack):
                stack.pop()
            if len(stack) < k:
                stack.append(nums[i])
        return stack
