// LeetCode 496. Next Greater Element I
// https://leetcode.com/problems/next-greater-element-i/
// O(n) time-and-space
function nextGreaterElement(nums1: number[], nums2: number[]): number[] {
    const numToNextGreater = new Map<number, number>(), monoStack = [];
    for (const num of nums2) {
        while (monoStack.length && monoStack[monoStack.length - 1] < num)
            numToNextGreater.set(monoStack.pop(), num);
        monoStack.push(num);
    }
    return nums1.map(num => numToNextGreater.get(num) || -1);
};
