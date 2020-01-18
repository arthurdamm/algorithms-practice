# LeetCode 39. Combination Sum
import bisect

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        solutions = set()
        self.dfs(candidates, [], target, solutions, len(candidates) - 1)
        return solutions
        
    def dfs(self, candidates: List[int], solution: List[int], target: int, solutions, i) -> List[List[int]]:
        if target < 0: return
        if target == 0:
            solutions.add(tuple(sorted(solution)))
            return
        while i >= 0:
            solution.append(candidates[i])
            self.dfs(candidates, solution, target - candidates[i], solutions, i)
            solution.pop()
            i -= 1
