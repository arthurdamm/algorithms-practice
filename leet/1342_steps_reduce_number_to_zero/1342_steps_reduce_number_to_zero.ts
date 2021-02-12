// LeetCode 1342. Number of Steps to Reduce a Number to Zero
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
// O(logn) time, O(1) space
function numberOfSteps (num: number): number {
    let steps = 0
    for (; num > 0; steps++)
        num & 1 ? num-- : num /= 2;
    return steps;
};

function numberOfStepsClever (num: number): number {
    let steps = num ? 0 : 1;
    for (; num > 0; (steps += (num & 1) + 1), num >>= 1) ;
    return steps - 1;
};
