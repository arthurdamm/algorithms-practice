// LeetCode 1329. Sort the Matrix Diagonally
// https://leetcode.com/problems/sort-the-matrix-diagonally/
// O(nmlog(nm)) time, O(nm) space
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        ArrayList<Integer> diagonals[] = new ArrayList[m + n - 1];
        for (int i = 0; i < diagonals.length; i++)
            diagonals[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = j - i >= 0 ? j - i : i - j + n - 1;
                diagonals[k].add(mat[i][j]);
            }
        }
        for (var list : diagonals)
            list.sort(Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = j - i >= 0 ? j - i : i - j + n - 1;
                mat[i][j] = diagonals[k].remove(diagonals[k].size() - 1);
            }
        }
        return mat;
    }
}
