# LeetCode 279. Perfect Squares
# https://leetcode.com/problems/perfect-squares/
# O(n) time & space
class Solution:
    def numSquares(self, n: int) -> int:
        squares = [k*k for k in range(1, int(math.sqrt(n)) + 1)]
        queue = deque([n])
        steps = 0
        seen = set()
        while queue:
            for _ in range(len(queue)):
                n = queue.popleft()
                if n == 0:
                    return steps
                for s in squares:
                    if n < s:
                        break
                    if n - s not in seen:
                        queue.append(n - s)
                        seen.add(n - s)
            steps += 1
        return -1
