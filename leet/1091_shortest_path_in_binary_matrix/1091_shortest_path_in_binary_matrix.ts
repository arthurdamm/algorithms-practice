// LeetCode 1091. Shortest Path in Binary Matrix
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// O(n) time-and-space
function shortestPathBinaryMatrix(grid: number[][]): number {
    const queue = grid[0][0] ? [] : [[0, 0]], m = grid.length, n = grid[0].length;
    const visited = new Array(m).fill(false).map(a => new Array(n).fill(false));
    const dirs = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
    for (let k = 1; queue.length; k++) {
        for (let sz = queue.length; sz > 0; sz--) {
            let [i, j] = queue.shift();
            if (i === m - 1 && j === n - 1)
                return k;
            for (let [ddi, ddj] of dirs) {
                let di = i + ddi, dj = j + ddj;
                if (di >= 0 && di < m && dj >= 0 && dj < n &&
                    !grid[di][dj] && !visited[di][dj]) {
                    visited[di][dj] = true;
                    queue.push([di, dj]);
                }
            }
            
        }
    }
    return -1;
};
