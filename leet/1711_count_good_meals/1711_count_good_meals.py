# LeetCode 1711. Count Good Meals
# https://leetcode.com/problems/count-good-meals/
# O(n) time, O(n) space
class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        meals, counter = 0, defaultdict(int)
        for n in deliciousness:
            for i in range(22):
                meals += counter[(1 << i) - n]
            counter[n] += 1
        return int(meals % (1e9 + 7))
