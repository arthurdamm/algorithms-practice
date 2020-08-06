#!/usr/bin/env python3
"""
322. Coin Change

You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
"""
class TopDownSolution:
    def coinChange(self, coins, amount) -> int:
        memo = {0: 0}
        coins.sort()
        def change(amount):
            if amount < 0:
                return float('inf')
            if amount in memo:
                return memo[amount]
            memo[amount] = 1 + min([change(amount - coin) for coin in coins])
            return memo[amount]
        return change(amount) if change(amount) < float('inf') else -1

input = [[1, 2, 5], 11]
print("Solution to", input, "is", TopDownSolution().coinChange(input[0], input[1]))

class BottomUpSolution:
    def coinChange(self, coins, amount) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        coins.sort()
        for i in range(1, amount + 1):
        	for c in coins:
        		if c > i:
        			break
        		if dp[i - c] > -1:
        			dp[i] = min(1 + dp[i - c], dp[i])
        return dp[amount] if dp[amount] < float('inf') else -1

print("Solution to", input, "is", BottomUpSolution().coinChange(input[0], input[1]))
