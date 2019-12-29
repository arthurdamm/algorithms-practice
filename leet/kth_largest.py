#!/usr/bin/env python3
# LeetCode 215 Kth Largest Element
# O(nlogk)

from typing import List
from heapq import *

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heappush(heap, num)
            if len(heap) > k:
                heappop(heap)
        return heappop(heap)

if __name__ == "__main__":
  d = [3,2,1,5,6,4]
  k = 2
  print("Solution()", d, k, ":", Solution().findKthLargest(d,k))
