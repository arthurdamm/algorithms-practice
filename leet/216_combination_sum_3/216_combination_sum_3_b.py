# LeetCode #216. Combination Sum III
# first working draft
# O(2^k) time
from typing import List
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        solution = []
        def dfs(nums, i, currsum):
            nonlocal n, k, solution
            if currsum == 0:
                if len(nums) == k:
                    solution.append(nums[:])
                return
            if currsum < 0: return
            for j in range(i, 10):
                nums.append(j)
                dfs(nums, j + 1, currsum - j)
                nums.pop()
        dfs([], 1, n)
        return solution

k = 3
n = 15
#print("Solution", k, n, Solution().combinationSum3(k, n))
