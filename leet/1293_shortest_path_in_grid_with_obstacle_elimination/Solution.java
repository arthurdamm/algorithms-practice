// LeetCode 1293. Shortest Path in a Grid with Obstacles Elimination
// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
// O(n*m*k) time-and-space
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, steps = 0;
        if (k >= m + n - 2)
            return m + n - 2;
        int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int visited[][]  = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        while (!queue.isEmpty()) {
            for (int x = queue.size(); x > 0; x--) {
                int[] node = queue.poll();
                int i = node[0], j = node[1], _k = node[2];
                if (i == m - 1 && j == n - 1)
                    return steps;
                for (int dir[] : dirs) {
                    int di = i + dir[0], dj = j + dir[1];
                    if (di >= 0 && di < m && dj >= 0 && dj < n) {
                        if (grid[di][dj] + _k <= k &&
                           grid[di][dj] + _k < visited[di][dj]) {
                            visited[di][dj] = grid[di][dj] + _k;
                            queue.offer(new int[]{di, dj, grid[di][dj] + _k});
                        }
                    }
                }

            }
            steps++;
        }
        return -1;
    }

}
