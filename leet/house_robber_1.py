# House Robber 1 LeetCode Problem
# Find max nonconsecutive integer sum

# Solution 1
# O(n) time complexity, O(n) space complexity
class Solution1:
    def rob(self, nums):
        if not nums:
            return 0
        dp = [0] * len(nums)
        if len(nums) < 3:
            return max(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[-1]
    
# Solution 2
# O(n) time complexity O(1) space complexity
class Solution2:
    def rob(self, nums):
        inclusive = 0
        exclusive = 0
        for num in nums:
            new = max(inclusive, exclusive + num)
            exclusive = inclusive
            inclusive = new
        return inclusive


if __name__ == "__main__":
    d = [1, 7, 5, 3, 4]
    print("rob():", Solution1().rob(d))
    print("rob():", Solution2().rob(d))
