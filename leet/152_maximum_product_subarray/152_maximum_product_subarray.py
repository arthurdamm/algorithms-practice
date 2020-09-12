# Leetcode #152. Maximum Product Subarray
# O(n) time, O(1) space
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        _max = float('-inf')
        m = 1
        for n in nums:
            m *= n
            _max = max(_max, m, n)
            if m is 0:
                m = 1
        nums.reverse()
        m = 1
        for n in nums:
            m *= n
            _max = max(_max, m, n)
            if m is 0:
                m = 1
        return _max
