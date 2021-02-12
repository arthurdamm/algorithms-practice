// LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
// O(n*m*k) time-and-space
function shortestPath(grid: number[][], k: number): number {
    let m = grid.length, n = grid[0].length;
    const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    const queue = [[0, 0, k, 0]];
    const visited = new Array(m).fill(0).map(a => new Array(n).fill(0).map(a => new Array()));
    let x = 0;
    while (x < queue.length) {
        for (let sz = queue.length; x < sz; x++) {
            let [i, j, k, s] = queue[x];
            if (visited[i][j][k])
                continue;
            visited[i][j][k] = true;
            if (i == m - 1 && j == n - 1)
                return s;
            for (let [ddi, ddj] of dirs) {
                let di = i + ddi, dj = j + ddj;
                if (di >= 0 && di < m && dj >= 0 && dj < n) {
                    if (grid[di][dj] == 1) {
                        if (k && !visited[di][dj][k - 1])
                            queue.push([di, dj, k - 1, s + 1])
                    } else if (!visited[di][dj][k])
                        queue.push([di, dj, k, s + 1]);
                }
            }
            
        }
    }
    return -1;
};
