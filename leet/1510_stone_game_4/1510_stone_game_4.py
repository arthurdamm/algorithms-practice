# LeetCode 1510. Stone Game IV
# https://leetcode.com/problems/stone-game-iv/
# O(n*root(n)) time, O(n) space
class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        memo = {}
        def canWin(n):
            if n == 0:
                return False
            if n not in memo:
                memo[n] = False
                for i in range(int(math.sqrt(n)), 0, -1):
                    if not canWin(n - i * i):
                        memo[n] = True
                        break
            return memo[n]
        return canWin(n)
