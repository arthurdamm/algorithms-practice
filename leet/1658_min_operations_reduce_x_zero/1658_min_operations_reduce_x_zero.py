# LeetCode 1658. Minimum Operations to Reduce X to Zero
# https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
# O(n) time O(1) space
class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        i, maxSubarray, target = 0, 0, sum(nums) - x
        if target <= 0:
            return len(nums) if target == 0 else -1
        for j in range(len(nums)):
            target -= nums[j]
            while target < 0:
                target += nums[i]
                i += 1
            if target == 0:
                maxSubarray = max(maxSubarray, j - i + 1)
        return len(nums) - maxSubarray if maxSubarray > 0 else -1

# O(n) time O(n) space using a Prefix Sum dictionary
class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        leftSums, currSum, minOps = defaultdict(int), 0, float('inf')
        for i in range(len(nums)):
            currSum += nums[i]
            leftSums[currSum] = i + 1
            if currSum > x:
                break
        if currSum < x:
            return -1
        if x in leftSums:
            minOps = leftSums[x]
        currSum = 0
        for i in range(len(nums) - 1, -1, -1):
            currSum += nums[i]
            if currSum == x:
                minOps = min(minOps, len(nums) - i)
            elif x - currSum in leftSums:
                minOps = min(minOps, leftSums[x - currSum] + len(nums) - i)
            elif currSum > x:
                break
        return -1 if minOps == float('inf') else minOps
