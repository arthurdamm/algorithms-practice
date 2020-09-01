from typing import List
import itertools

class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:
        for h1, h2, m1, m2 in reversed(sorted(itertools.permutations(A))):
            if h1 > 2: continue
            if h1 == 2 and h2 > 3: continue
            if m1 > 5: continue
            return "{}{}:{}{}".format(h1, h2, m1, m2)
        return ""

data = [2,0,6,6]
print("Solution to", data, Solution().largestTimeFromDigits(data))
data = [9, 5, 2, 3]
print("Solution to", data, Solution().largestTimeFromDigits(data))
