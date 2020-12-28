# LeetCode 1345. Jump Game IV
# https://leetcode.com/problems/jump-game-iv/
# O(n) time O(n) space
class Solution:
    def minJumps(self, arr: List[int]) -> int:
        edges = defaultdict(list)
        for i, n in enumerate(arr):
            edges[n].append(i)
        steps, queue, visited = 0, deque(), set()
        queue.append(0)
        while len(queue):
            for _ in range(len(queue)):
                i = queue.popleft()
                if i == len(arr) - 1:
                    return steps
                visited.add(i)
                if i > 0 and i - 1 not in visited:
                    queue.append(i - 1)
                if i < len(arr) - 1 and i + 1 not in visited:
                    queue.append(i + 1)
                if arr[i] in edges:
                    for j in edges[arr[i]]:
                        if j not in visited:
                            queue.append(j)
                    del edges[arr[i]]
            steps += 1
        return steps
