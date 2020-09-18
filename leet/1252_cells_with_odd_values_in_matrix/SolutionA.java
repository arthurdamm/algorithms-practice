// LeetCode 1252. Cells with Odd Values in a Matrix
// O(k*(m+n)) time, O(m*n) space
class SolutionA {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < m; j++)
                matrix[indices[i][0]][j]++;
            for (int j = 0; j < n; j++)
                matrix[j][indices[i][1]]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                count += matrix[i][j] % 2;
        return count;
    }
}
