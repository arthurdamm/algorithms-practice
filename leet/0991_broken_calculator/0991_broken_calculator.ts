// LeetCode 991. Broken Calculator
// https://leetcode.com/problems/broken-calculator/
// O(logn) time, O(1) space
function brokenCalc(X: number, Y: number): number {
    let ops = 0;
    if (X >= Y)
        return X - Y;
    for (; Y > X; ops++)
        Y = Y % 2 == 0 ? Y / 2 : Y + 1;
    return ops + X - Y;
};
