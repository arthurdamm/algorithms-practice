// LeetCode 240. Search a 2D Matrix II
// https://leetcode.com/problems/search-a-2d-matrix-ii/
// O(n + m) time, O(1) space
function searchMatrix(matrix: number[][], target: number): boolean {
    let i = matrix.length - 1, j = 0;
    while (i >= 0 && j < matrix[0].length) {
        if (target == matrix[i][j])
            return true;
        else if (target < matrix[i][j])
            i--;
        else
            j++;
    }
    return false
};
