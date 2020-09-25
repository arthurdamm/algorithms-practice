# LeetCode 179. Largest Number
# O(nlogn) (assuming bounded length of integers)
from functools import cmp_to_key
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        return "0" if sum(nums) == 0 else "".join(sorted([str(n) for n in nums], key=cmp_to_key(lambda x, y: 1 if x + y < y + x else -1 )))
