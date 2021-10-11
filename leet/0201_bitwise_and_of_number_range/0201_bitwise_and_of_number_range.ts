// LeetCode 201. Bitwise AND of Numbers Range
// https://leetcode.com/problems/bitwise-and-of-numbers-range/
// O(log(n)) time, O(1) space
function rangeBitwiseAnd(left: number, right: number): number {
    let shift = 0;
    while (left != right)
        left >>= 1, right >>= 1, shift++;
    return left << shift;
    
};

function rangeBitwiseAndKernighan(left: number, right: number): number {
    while (right > left)
        right &= (right - 1);
    return right;
}
