// LeetCode 883. Projection Area of 3D Shapes
// https://leetcode.com/problems/projection-area-of-3d-shapes/
// O(n * m) time, O(1) space
class Solution {
    public int projectionArea(int[][] grid) {
        int xy = 0, yz = 0, zx = 0;
        for (int x = 0; x < grid.length; x++) {
            int maxZX = 0, maxYZ = 0;
            for (int y = 0; y < grid[0].length; y++) {
                xy += grid[x][y] != 0 ? 1 : 0;
                maxZX = Math.max(maxZX, grid[x][y]);
                maxYZ = Math.max(maxYZ, grid[y][x]);
            }
            zx += maxZX;
            yz += maxYZ;
        }
        return xy + yz + zx;
    }
}
