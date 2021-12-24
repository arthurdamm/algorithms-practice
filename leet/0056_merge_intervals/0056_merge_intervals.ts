// LeetCode 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
// O(nlogn) time, O(1) space
function merge(intervals: number[][]): number[][] {
    intervals.sort(([a1, a2], [b1, b2]) => a1 - b1);
    let a = intervals[0];
    for (let i = 1; i < intervals.length; i++) {
        const b = intervals[i];
        if (a[1] >= b[0] && a[0] <= b[1]) {
            a[1] = Math.max(a[1], b[1]);
            b[0] = -1;
        } else
            a = b;
    }
    return intervals.filter(([n1, n2])=> n1 != -1);
};

