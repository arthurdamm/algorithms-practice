// LeetCode 413. Arithmetic Slices
// https://leetcode.com/problems/arithmetic-slices/
// O(n) time, O(1) space
function numberOfArithmeticSlices(A: number[]): number {
    if (A.length < 3) return 0;
    let len = 1, diff:number = A[1] - A[0], slices:number = 0;
    for (let i = 0; i < A.length - 1; i++) {
        if (A[i + 1] - A[i] === diff) {
            len += 1;
        } else {
            slices += (len >= 3) ? (len - 2)*(len - 1) / 2 : 0
            diff = A[i + 1] - A[i];
            len = 2;
        }
    }
    slices += (len >= 3) ? (len - 2)*(len - 1) / 2 : 0
    return Math.floor(slices);
};
