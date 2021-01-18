# LeetCode 1539. Kth Missing Positive Number
# https://leetcode.com/problems/kth-missing-positive-number/
# O(logn) time, O(1) space
class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        lo, hi = 0, len(arr)
        while lo < hi:
            mid = (lo + hi) // 2
            if arr[mid] - mid - 1 < k:
                lo = mid + 1
            else:
                hi = mid
        return lo + k
