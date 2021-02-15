// LeetCode 1337. The K Weakest Rows in a Matrix
// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
// O((m + n)logn) time, O(m) space
function kWeakestRows(mat: number[][], k: number): number[] {
    const binarySearchFirstZero = (row: number[]): number => {
        let lo = 0, hi = row.length;
        while (lo < hi) {
            let mid = Math.floor(lo + (hi - lo) / 2);
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }  
    return new Array(mat.length).fill([])
        .map((a, i) => [binarySearchFirstZero(mat[i]), i])
        .sort((a, b) => (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]))
        .map(a => a[1])
        .slice(0, k);
};
