// LeetCode 476. Number Complement
// https://leetcode.com/problems/number-complement/
// O(1) time-and-space
function findComplement(num: number): number {
    let n = num;
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 16;
    return ~num & n;
};
