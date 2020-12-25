// LeetCode 498. Diagonal Traverse
// https://leetcode.com/problems/diagonal-traverse/
// O(m * n) time & space
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length, A[] = new int[m * n];
        int i = 0, j = 0, k = 0;
        while (k < m * n) {
            for (; i >= 0 && j <= n - 1; i--, j++)
                A[k++] = matrix[i][j];
            i++;
            if (j >= n) {
                i++;
                j--;
            }
            for (; i <= m - 1 && j >= 0; i++, j--)
                A[k++] = matrix[i][j];
            j++;
            if (i >= m) {
                i--;
                j++;
            }
        }
        return A;
        
    }
}

class SolutionB {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        ArrayList<Integer>[] diagonals = new ArrayList[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (diagonals[i + j] == null)
                    diagonals[i + j] = new ArrayList<>();
                diagonals[i + j].add(matrix[i][j]);
            }
        }
        int A[] = new int[m * n], j = 0;
        for (int i = 0; i < diagonals.length; i++) {
            if (i % 2 == 0)
                Collections.reverse(diagonals[i]);
            for (int a : diagonals[i])
                A[j++] = a;
        }
        return A;
    }
}
