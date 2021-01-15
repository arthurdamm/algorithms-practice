# LeetCode 1042. Flower Planting With No Adjacent
# https://leetcode.com/problems/flower-planting-with-no-adjacent/
# O(n + m) time, O(n) space
class Solution:
    def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:
        graph = defaultdict(set)
        for path in paths:
            graph[path[0]].add(path[1])
            graph[path[1]].add(path[0])
        nodes = [0] * (n + 1)
        for i in range(1, n + 1):
            colors = {1, 2, 3, 4}
            for neighbor in graph[i]:
                colors.discard(nodes[neighbor])
            nodes[i] = colors.pop()
        return nodes[1:]
