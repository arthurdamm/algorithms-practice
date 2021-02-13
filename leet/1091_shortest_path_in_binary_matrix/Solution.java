// LeetCode 1091. Shortest Path in Binary Matrix
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// O(n) time-and-space
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[m][n];
        int dirs[][] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        if (grid[0][0] == 0)
            queue.offer(new int[]{0, 0});
        for (int k = 1; !queue.isEmpty(); k++) {
            for (int sz = queue.size(); sz > 0; sz--) {
                int pair[] = queue.poll(), i = pair[0], j = pair[1];
                if (i == m - 1 && j == n - 1)
                    return k;
                for (int[] dir : dirs) {
                    int di = i + dir[0], dj = j + dir[1];
                    if (di >= 0 && di < m && dj >= 0 && dj < n &&
                        grid[di][dj] == 0 && !visited[di][dj]) {
                        visited[di][dj] = true;
                        queue.offer(new int[]{di, dj});
                    }
                }

            }
        }
        return -1;  
    }
}
