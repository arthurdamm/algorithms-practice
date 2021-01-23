// LeetCode 1329. Sort the Matrix Diagonally
// https://leetcode.com/problems/sort-the-matrix-diagonally/
// O(nmlog(nm)) time, O(nm) space
var diagonalSort = function(mat) {
    let m = mat.length, n = mat[0].length;
    let diagonals = new Array(m + n - 1);
    for (let i = 0; i < diagonals.length; i++)
        diagonals[i] = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let k = j - i >= 0 ? j - i : i - j + n - 1;
            diagonals[k].push(mat[i][j]);
        }
    }
    for (let list of diagonals)
        list.sort((a,b)=>b-a);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let k = j - i >= 0 ? j - i : i - j + n - 1;
            mat[i][j] = diagonals[k].pop();
        }
    }
    return mat;
};
