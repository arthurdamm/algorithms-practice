#!/usr/bin/env python3
# LeetCode Coin Change
# O(nm)

class Solution:
  def coinChange(self, coins, amount):
    dp = [amount + 1] * (amount + 1)
    dp[0] = 0
    for i in range(0, amount + 1):
      for coin in coins:
        if i >= coin:
          dp[i] = min(dp[i], 1 + dp[i - coin])
    return dp[amount] if dp[amount] <= amount else -1

if __name__ == "__main__":
  d = [[1, 2, 5], 11]
  print("Solution for ", d, ":", Solution().coinChange(d[0], d[1]))
