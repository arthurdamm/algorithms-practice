#!/usr/bin/env python3

class Solution:
    def eventualSafeNodes(self, graph) -> int:
        visited = {}
        def dfs(node):
            if node in visited:
                return visited[node]
            visited[node] = 1
            if all([dfs(neighbor) == 2 for neighbor in graph[node]]):
                visited[node] = 2
                return 2
            return 1
        for node in range(len(graph)):
            if node not in visited:
                dfs(node)
        return sorted([node for node in visited.keys() if visited[node] == 2])

graph = [[1,2],[2,3],[5],[0],[5],[],[]]
print("Solution to", graph, Solution().eventualSafeNodes(graph))