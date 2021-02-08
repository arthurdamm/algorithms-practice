// LeetCode 1129. Shortest Path with Alternating Colors
// https://leetcode.com/problems/shortest-path-with-alternating-colors/
// O(E+V) time, O(E+V) space
function shortestAlternatingPaths(n: number, red_edges: number[][], blue_edges: number[][]): number[] {
    enum Edge {
        Red = "reds",
        Blue = "blues"
    }
    const edges = {reds: {}, blues: {}};
    for (let [from, to] of red_edges) {
        if (!edges.reds[from])
            edges.reds[from] = new Set();
        edges.reds[from].add(to);
    }
    for (let [from, to] of blue_edges) {
        if (!edges.blues[from])
            edges.blues[from] = new Set();
        edges.blues[from].add(to);
    }
    const visited = {
        reds: new Array(n).fill(-1), blues: new Array(n).fill(-1) };
    const dfs = function(i, color, steps) {
        if (visited[color][i] != -1 && steps >= visited[color][i])
            return;
        visited[color][i] = steps;
        if (!edges[color][i])
            return;
        edges[color][i].forEach((edge)=>(
            dfs(edge, color === Edge.Red ? Edge.Blue : Edge.Red, steps + 1)));
    }
    
    dfs(0, Edge.Red, 0);
    dfs(0, Edge.Blue, 0);
    return visited.blues.map((b, i) =>
        b == -1 || visited.reds[i] == -1
            ? b == -1 ? visited.reds[i] : b
            : Math.min(b, visited.reds[i])
        );
};
