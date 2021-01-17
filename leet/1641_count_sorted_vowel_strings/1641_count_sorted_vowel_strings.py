# LeetCode 1641. Count Sorted Vowel Strings
# https://leetcode.com/problems/count-sorted-vowel-strings/
# O(nk) time-and-space
class Solution:
	def countVowelStrings(self, n: int) -> int:
		dp = [[1 if i == 0 and j != 0 else 0 for j in range(6)] for i in range(n)]
		for i in range(1, n):
			for vowel in range(1, 6):
				dp[i][vowel] = dp[i][vowel - 1] + dp[i - 1][vowel]
		return sum(dp[-1])


class SolutionTopDown:
	def countVowelStrings(self, n: int) -> int:
		memo = [[1 if i == 0 else 0 if j == 0 else -1 for j in range(6)] for i in range(n + 1)]
		memo[0][0] = 0
		def dp(i, vowel):
			if memo[i][vowel] == -1:
				memo[i][vowel] = dp(i, vowel - 1) + dp(i - 1, vowel)
			return memo[i][vowel]
		return dp(n, 5)
