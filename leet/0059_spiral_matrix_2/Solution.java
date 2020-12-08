// LeetCode 59. Spiral Matrix 2
// O(n*n) time, O(1) space
class Solution {
    public int[][] generateMatrix(int n) {
        int r1 = 0, c1 = 0, r2 = n - 1, c2 = n - 1, i = 1;
        int[][] matrix = new int[n][n];
        while (r2 >= r1 && c2 >= c1) {
            for (int c = c1; c <= c2; c++)
                matrix[r1][c] = i++;
            for (int r = r1 + 1; r <= r2; r++)
                matrix[r][c2] = i++;
            if (r2 != r1)
                for (int c = c2 - 1; c >= c1; c--)
                    matrix[r2][c] = i++;
            if (c2 != c1)
                for (int r = r2 - 1; r > r1; r--)
                    matrix[r][c1] = i++;
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return matrix;
    }
}
