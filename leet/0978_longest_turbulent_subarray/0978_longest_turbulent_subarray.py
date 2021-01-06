# LeetCode 978. Longest Turbulent Subarray
# https://leetcode.com/problems/longest-turbulent-subarray/
# O(n) time O(1) space
class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        start, _max = 0, 1
        if len(arr) > 1:
            if arr[0] == arr[1]:
                start = 1
            else:
                _max = 2
        for i in range(2, len(arr)):
            if arr[i] == arr[i - 1]:
                _max = max(_max, i - start)
                start = i
            elif (arr[i - 2] > arr[i - 1] > arr[i] or
                  arr[i - 2] < arr[i - 1] < arr[i]):
                _max = max(_max, i - start)
                start = i - 1
        return max(_max, len(arr) - start)
