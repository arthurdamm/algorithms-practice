// LeetCode 1129. Shortest Path with Alternating Colors
// https://leetcode.com/problems/shortest-path-with-alternating-colors/
// O(E+V) time, O(E+V) space
class Solution {
    Map<Integer, Set<Integer>> redEdges = new HashMap<>(), blueEdges = new HashMap<>();
    int[] redVisited, blueVisited;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        redVisited = new int[n];
        blueVisited = new int[n];
        Arrays.fill(redVisited, Integer.MAX_VALUE);
        Arrays.fill(blueVisited, Integer.MAX_VALUE);
        for (int[] edge : red_edges) {
            redEdges.computeIfAbsent(edge[0], k -> new HashSet<>());
            redEdges.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blue_edges) {
            blueEdges.computeIfAbsent(edge[0], k -> new HashSet<>());
            blueEdges.get(edge[0]).add(edge[1]);
        }
        dfs(0, true, 0);
        dfs(0, false, 0);
        for (int i = 0; i < n; i++) {
            if (redVisited[i] == Integer.MAX_VALUE &&
               blueVisited[i] == Integer.MAX_VALUE)
                redVisited[i] = -1;
            else
                redVisited[i] = Math.min(redVisited[i], blueVisited[i]);
        }
        return redVisited;
    }
    
    private void dfs(int i, boolean isRed, int steps) {
        var edges = isRed ? redEdges : blueEdges;
        var visited = isRed ? redVisited : blueVisited;
        if (steps >= visited[i])
            return;
        visited[i] = steps;
        if (edges.containsKey(i))
            for (int edge : edges.get(i))
                dfs(edge, !isRed, steps + 1);
    }
}
