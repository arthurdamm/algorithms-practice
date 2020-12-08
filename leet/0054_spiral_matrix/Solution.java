// LeetCode 54. Spiral Matrix
// O(m*n) time O(1) space
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r1 = 0, c1 = 0, r2 = matrix.length - 1,
            c2 = matrix[0].length - 1;
        List<Integer> flat = new ArrayList<>();
        while (r2 >= r1 && c2 >= c1) {
            for (int c = c1; c <= c2; c++)
                flat.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++)
                flat.add(matrix[r][c2]);
            if (r2 != r1)
                for (int c = c2 - 1; c >= c1; c--)
                    flat.add(matrix[r2][c]);
            if (c2 != c1)
                for (int r = r2 - 1; r > r1; r--)
                    flat.add(matrix[r][c1]);
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return flat;
    }
}
