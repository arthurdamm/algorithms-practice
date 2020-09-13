# LeetCode #216. Combination Sum III
# first working draft
# O(2^k) time
from typing import List
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        solution = []
        def dfs(nums, N, K):
            nonlocal n, k, solution
            if len(nums) == k:
                if N == n:
                    solution += [nums]
                return
            if K <= 9:
                dfs(nums + [K], N + K, K + 1)
                dfs(nums, N, K + 1)
        dfs([], 0, 1)
        return solution

k = 3
n = 15
#print("Solution", k, n, Solution().combinationSum3(k, n))
