# LeetCode 464. Can I Win
# https://leetcode.com/problems/can-i-win/
# O(n*2^n) time, O(2^n) space
class Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        memo = {}
        def choose(chosenBits, total):
            if total >= desiredTotal:
                return False
            if chosenBits in memo:
                return memo[chosenBits]
            result = False
            for i in range(0, maxChoosableInteger):
                if chosenBits & (1 << i) == 0:
                    if not choose(chosenBits | (1 << i), total + i + 1):
                        result = True
                        break
            memo[chosenBits] = result
            return result
        if (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal:
            return False
        return choose(0, 0) if desiredTotal else True
