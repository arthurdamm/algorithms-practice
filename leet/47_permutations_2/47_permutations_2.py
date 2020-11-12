# LeetCode 47. Permutations II
# O(n!) time O(n) space
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        queue = deque(nums)
        self.ret = set()
        self.dfs([], queue)
        return self.ret

    def dfs(self, nums, queue):
        if len(queue) == 0:
            self.ret.add(tuple(nums))
            return
        for _ in range(len(queue)):
            nums.append(queue.popleft())
            self.dfs(nums, queue)
            queue.append(nums.pop())

