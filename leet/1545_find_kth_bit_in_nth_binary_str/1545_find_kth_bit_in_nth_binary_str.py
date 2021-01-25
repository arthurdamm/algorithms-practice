# LeetCode 1545. Find Kth Bit in Nth Binary String
# https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
# O(n) time, O(1) space
class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        if n <= 2:
            return "0" if k == 1 else "1"
        lenS = 2**n - 1
        mid = (lenS + 1) // 2
        midOfSecondHalf = mid + mid // 2
        if k == mid:
            return "1"
        if k == midOfSecondHalf:
            return "0"
        return self.findKthBit(n - 1, k % mid)
