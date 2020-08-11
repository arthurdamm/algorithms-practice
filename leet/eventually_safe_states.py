#!/usr/bin/env python3

class Solution:
    def eventualSafeNodes(self, graph) -> int:
        VISITED, SAFE, visited = 1, 2, {}
        def dfs(node):
            if node in visited:
                return visited[node]
            visited[node] = VISITED
            if all([dfs(neighbor) == SAFE for neighbor in graph[node]]):
                visited[node] = SAFE
                return SAFE
            return VISITED
        for node in range(len(graph)):
            if node not in visited:
                dfs(node)
        return sorted([node for node in visited.keys() if visited[node] == SAFE])

graph = [[1,2],[2,3],[5],[0],[5],[],[]]
print("Solution to", graph, Solution().eventualSafeNodes(graph))