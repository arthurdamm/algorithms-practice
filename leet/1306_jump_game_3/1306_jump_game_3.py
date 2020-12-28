# LeetCode 1306. Jump Game III
# https://leetcode.com/problems/jump-game-iii/
# O(n) time O(1) space
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        def dfs(i):
            if i < 0 or i >= len(arr) or arr[i] < 0:
                return False
            if arr[i] == 0:
                return True
            arr[i] *= -1
            return dfs(i - arr[i]) or dfs(i + arr[i])
        return dfs(start)
