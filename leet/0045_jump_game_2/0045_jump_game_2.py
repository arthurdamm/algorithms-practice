# LeetCode 45. Jump Game II
# https://leetcode.com/problems/jump-game-ii/
# O(n) time, O(1) space
class Solution:
    def jump(self, nums: List[int]) -> int:
        i, end, maxEnd, jumps = 0, 0, 0, 0
        if (len(nums) < 2):
            return 0
        while i <= end:
            maxEnd = max(maxEnd, i + nums[i])
            if i == end:
                end = maxEnd
                jumps += 1
                if end >= len(nums) - 1:
                    break
            i += 1
        return jumps
