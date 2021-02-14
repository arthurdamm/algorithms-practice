// LeetCode 785. Is Graph Bipartite?
// https://leetcode.com/problems/is-graph-bipartite/
// O(n) time-and-space
function isBipartite(graph: number[][]): boolean {
    enum Color { Red = 1, Blue };
    const colors:number[] = new Array(graph.length).fill(0);
    const dfs = (u, color) => {
        if (colors[u])
            return colors[u] == color;
        colors[u] = color;
        for (let v of graph[u])
            if (!dfs(v, color == Color.Red ? Color.Blue : Color.Red))
                return false;
        return true;
    }
    for (let i = 0; i < graph.length; i++)
        if (!colors[i] && !dfs(i, Color.Red))
            return false;
    return true;
};
