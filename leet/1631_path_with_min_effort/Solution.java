// LeetCode 1631. Path With Minimum Effort
// https://leetcode.com/problems/path-with-minimum-effort/
// O(nlogk) O(n)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        Integer[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[heights.length][heights[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new Integer[]{0, 0, 0});

        while (!pq.isEmpty()) {
            Integer[] node = pq.poll();
            int currMax = node[0], i = node[1], j = node[2];
            
            if (i == heights.length - 1 && j == heights[0].length - 1)
                return currMax;
            if (visited[i][j] <= currMax)
                continue;
            visited[i][j] = currMax;
            for (Integer[] dir : dirs) {
                int di = i + dir[0],  dj = j + dir[1];
                if (di >= 0 && di < heights.length && dj >= 0 && dj < heights[0].length) {
                    int tempMax = Math.max(currMax, Math.abs(heights[i][j] - heights[di][dj]));
                    if (tempMax < visited[di][dj])
                        pq.offer(new Integer[]{tempMax, di, dj});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
