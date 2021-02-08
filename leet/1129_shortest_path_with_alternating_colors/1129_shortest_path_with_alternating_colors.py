# LeetCode 1129. Shortest Path with Alternating Colors
# https://leetcode.com/problems/shortest-path-with-alternating-colors/
# O(E+V) time, O(E+V) space
class Solution:
    def shortestAlternatingPaths(self, n: int, red_edges: List[List[int]], blue_edges: List[List[int]]) -> List[int]:
        redEdges, blueEdges = defaultdict(set), defaultdict(set)
        [redEdges[a].add(b) for (a, b) in red_edges]
        [blueEdges[a].add(b) for (a, b) in blue_edges]
        redVisited = [float(inf)] * n
        blueVisited = [float(inf)] * n
        
        def dfs(i, isRed, steps):
            visited = redVisited if isRed else blueVisited
            edges = redEdges if isRed else blueEdges
            if steps >= visited[i]:
                return
            visited[i] = steps
            for edge in edges[i]:
                dfs(edge, not isRed, steps + 1)
        
        dfs(0, True, 0)
        dfs(0, False, 0)
        return [min(r, b) if min(r, b) < float('inf') else -1 for r, b in zip(redVisited, blueVisited)]
