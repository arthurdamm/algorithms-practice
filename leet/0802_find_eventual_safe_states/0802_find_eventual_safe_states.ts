// LeetCode 802. Find Eventual Safe States
// https://leetcode.com/problems/find-eventual-safe-states/
// O(n) time-and-space
function eventualSafeNodes(graph: number[][]): number[] {
    let visited = new Array(graph.length).fill(" ");
    const dfs = i => {
        visited[i] = "V";
        for (let outgoing of graph[i]) {
            if (visited[outgoing] !== " ") {
                if (visited[outgoing] != "S") {
                    visited[i] = "U";
                    return false;
                }
            } else {
                if (!dfs(outgoing)) {
                    visited[i] = "U";
                    return false;
                }
            }
        }
        visited[i] = "S";
        return true;
    }
    
    let result = [];
    for (let i = 0; i < graph.length; i++) {
        if (visited[i] === " ")
            dfs(i);
        if (visited[i] === "S")
            result.push(i);
    }
    return result;
};
