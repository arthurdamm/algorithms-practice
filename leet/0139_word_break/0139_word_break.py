# LeetCode 139. Word Break
# https://leetcode.com/problems/word-break/
# O(m*n*o) time O(m) space
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [0] * (len(s) + 1)
        for i in range(len(s)):
            if i == 0 or dp[i] != 0:
                for word in wordDict:
                    if s[i:i+len(word)] == word:
                        dp[i + len(word)] += 1
        return dp[-1] != 0


# O(m*n*o) time O(m) space
class SolutionTopDown:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = {len(s) : True}
        def search(i):
            if i in memo:
                return memo[i]
            memo[i] = False
            for word in wordDict:
                if s[i:i+len(word)] == word:
                    if search(i + len(word)):
                        memo[i] = True
                        break                        
            return memo[i]
        return search(0)
