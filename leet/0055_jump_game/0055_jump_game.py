# LeetCode 55. Jump Game
# https://leetcode.com/problems/jump-game/
# O(n) time, O(1) space
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        i, maxJump = 0, 0
        while i <= maxJump:
            maxJump = max(maxJump, i + nums[i])
            if i >= len(nums) - 1:
                return True
            i += 1
        return False
