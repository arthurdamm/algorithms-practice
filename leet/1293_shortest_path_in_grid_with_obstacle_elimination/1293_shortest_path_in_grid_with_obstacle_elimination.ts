// LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
// O(n*m*k) time-and-space
function shortestPath(grid: number[][], k: number): number {
    let m = grid.length, n = grid[0].length;
    if (k >= m + n - 2)
        return m + n - 2;
    const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    const queue = [[0, 0, 0]];
    const visited = new Array(m).fill(0).map(a => new Array(n).fill(Number.MAX_SAFE_INTEGER));
    let x = 0, steps = 0;
    while (x < queue.length) {
        for (let sz = queue.length; x < sz; x++) {
            let [i, j, _k] = queue[x];
            if (i == m - 1 && j == n - 1)
                return steps;
            for (let [ddi, ddj] of dirs) {
                let di = i + ddi, dj = j + ddj;
                if (di >= 0 && di < m && dj >= 0 && dj < n) {
                    let nextK = grid[di][dj] + _k;
                    if (nextK <= k && visited[di][dj] > nextK) {
                        visited[di][dj] = nextK;
                        queue.push([di, dj, nextK]);
                    }
                }
            }
            
        }
        steps++;
    }
    return -1;
};
