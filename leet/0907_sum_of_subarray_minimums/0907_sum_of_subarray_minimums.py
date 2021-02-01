# LeetCode 907. Sum of Subarray Minimums
# https://leetcode.com/problems/sum-of-subarray-minimums/
# O(n) time-and-space
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        MOD = int(1e9) + 7
        stack = []
        leftCounts = [0] * len(arr)
        rightCounts = [0] * len(arr)
        for i in range(len(arr)):
            count = 0
            while stack and stack[-1][0] > arr[i]:
                count += 1 + stack.pop()[1]
            stack.append((arr[i], count))
            leftCounts[i] = count + 1
        stack = []
        for i in range(len(arr) - 1, -1, -1):
            count = 0
            while stack and stack[-1][0] >= arr[i]:
                count += 1 + stack.pop()[1]
            stack.append((arr[i], count))
            rightCounts[i] = count + 1
        ret = 0
        print(leftCounts, rightCounts)
        for i in range(len(arr)):
            ret = (ret + arr[i] * leftCounts[i] * rightCounts[i]) % MOD
        return ret
