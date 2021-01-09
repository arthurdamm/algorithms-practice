// LeetCode 240. Search a 2D Matrix II
// https://leetcode.com/problems/search-a-2d-matrix-ii/
// O(log(max(n, m)) time and space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, 0, matrix.length, matrix[0].length);
    }
    
    boolean search(int[][] matrix, int target, int i, int j, int n, int m) {
        if (i >= matrix.length || j >= matrix[0].length)
            return false;
        if (n == 1 || m == 1)
            return binarySearchRowOrColumn(matrix, target, i, j, n, m);
        
        int[] pivot = binarySearchDiagonal(matrix, target, i, j, n, m);
        if (matrix[pivot[0]][pivot[1]] > target)
            return false;
        if (matrix[pivot[0]][pivot[1]] == target)
            return true;
        return search(matrix, target, i, pivot[1] + 1, pivot[0] - i + 1, m - (pivot[1] + 1 - j)) ||
                search(matrix, target, pivot[0] + 1, j, n - (pivot[0] + 1 - i), pivot[1] + 1 - j);
    }
    
    int[] binarySearchDiagonal(int[][] matrix, int target, int i, int j, int n, int m) {
        int lo_i = i, lo_j = j, hi_i = i + n, hi_j = j + m, mid;
        while (lo_i < hi_i && lo_j < hi_j) {
            int mid_i = lo_i + (hi_i - lo_i) / 2, mid_j = lo_j + (hi_j - lo_j) / 2;
            if (matrix[mid_i][mid_j] == target)
                return new int[]{mid_i, mid_j};
            else if (matrix[mid_i][mid_j] < target) {
                lo_i = mid_i + 1;
                lo_j = mid_j + 1;
            } else {
                hi_i = mid_i;
                hi_j = mid_j;
            }
        }
        return new int[]{Math.max(i, lo_i - 1), Math.max(j, lo_j - 1)};
    }
    
    boolean binarySearchRowOrColumn(int[][] matrix, int target, int i, int j, int n, int m) {
        if (n == 1) {
            int lo = j, hi = j + m;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            return false;
        } else if (m == 1) {
            int lo = i, hi = i + n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[mid][j] == target)
                    return true;
                else if (matrix[mid][j] < target)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            return false;
        }
        return false;
    }
}
