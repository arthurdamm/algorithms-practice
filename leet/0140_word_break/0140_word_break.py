# LeetCode 140. Word Break II
# https://leetcode.com/problems/word-break-ii/
# O(m*n*o) time-and-space
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        dp = [None] * (len(s) + 1)
        for i in range(len(s)):
            if i == 0 or dp[i] != None:
                for word in wordDict:
                    if s[i:i+len(word)] == word:
                        if dp[i+len(word)] == None:
                            dp[i+len(word)] = []
                        dp[i + len(word)].append(word)
        ret = []
        def getWords(i, words):
            if i == 0:
                ret.append(" ".join(reversed(words)))
                return
            for word in dp[i]:
                words.append(word)
                getWords(i - len(word), words)
                words.pop()
        if dp[len(s)]:
            getWords(len(s), [])
        return ret
