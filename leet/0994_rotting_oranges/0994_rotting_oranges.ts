// LeetCode 994. Rotting Oranges
// https://leetcode.com/problems/rotting-oranges/
// O(n) time-and-space
function orangesRotting(grid: number[][]): number {
    let freshCount = 0, queue = [], minutes = -1;
    for (let row = 0; row < grid.length; row++) {
        for (let col = 0; col < grid[row].length; col++) {
            if (grid[row][col] == 2) {
                queue.push([row, col]);
            } else if(grid[row][col] == 1)
                freshCount++;
        }
    }
    if (!freshCount)
        return 0;
    while (queue.length > 0) {
        minutes++;
        for (let i = queue.length - 1; i >= 0; i--) {
            const [row, col] = queue.shift();
            for (const [dr, dc] of [[0, 1], [1, 0], [0, -1], [-1, 0]]) {
                const nextRow = row + dr, nextCol = col + dc;
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 &&
                    nextCol < grid[nextRow].length && grid[nextRow][nextCol] == 1) {
                    grid[nextRow][nextCol] = 2;
                    queue.push([nextRow, nextCol])
                    freshCount--;
                }
            }
            
        }
    }
    return freshCount == 0 ? minutes : -1;
};
