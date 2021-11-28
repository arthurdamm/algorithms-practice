// LeetCode 797. All Paths From Source to Target
// https://leetcode.com/problems/all-paths-from-source-to-target/
// O(2^n) time-and-space
function allPathsSourceTarget(graph: number[][]): number[][] {
    const solutions = [];
    const dfs = (i, path) => {
        if (i === graph.length - 1) {
            solutions.push([...path])
            return;
        }
        for (const nextStep of graph[i]) {
            path.push(nextStep);
            dfs(nextStep, path);
            path.pop();
        }
    }
    dfs(0, [0]);
    return solutions;
};
