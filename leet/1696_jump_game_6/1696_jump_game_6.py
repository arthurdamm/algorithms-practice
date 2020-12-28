# LeetCode 1696. Jump Game VI
# https:#leetcode.com/problems/jump-game-vi/
# O(nlogn) time O(k) space
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        dp = -nums[-1]
        pq = [(dp, len(nums) - 1)]
        for i in range(len(nums) - 2, -1, -1):
            while pq[0][1] > i + k:
                heapq.heappop(pq)
            dp = pq[0][0] - nums[i]
            heapq.heappush(pq, (dp, i))
        return -dp


# O(n) time O(k) space
class SolutionDeque:
    def maxResult(self, nums: List[int], k: int) -> int:
        dq = deque()
        dq.append((len(nums) - 1, nums[-1]))
        dp = nums[-1]
        for i in range(len(nums) - 2, -1, -1):
            while dq[0][0] > i + k:
                dq.popleft()
            dp = nums[i] + dq[0][1]
            while dq and dq[-1][1] < dp:
                dq.pop()
            dq.append((i, dp))
        return dp
