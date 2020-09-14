# LeetCode 198. House Robber
# O(n) time O(1) space
class Solution:
    def rob(self, nums: List[int]) -> int:
        inc = exc = 0
        for num in nums:
            temp = inc
            inc = max(inc, exc + num)
            exc = temp
        return inc
