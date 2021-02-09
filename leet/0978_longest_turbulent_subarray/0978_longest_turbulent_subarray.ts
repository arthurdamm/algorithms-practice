// LeetCode 978. Longest Turbulent Subarray
// https://leetcode.com/problems/longest-turbulent-subarray/
// O(n) time, O(1) space
function maxTurbulenceSize(arr: number[]): number {
    let max = 0;
    for (let i = 0, j = 0; j < arr.length; j++) {
        if (j > i && arr[j] === arr[j - 1])
            i = j;
        else if (j > i + 1) {
            if ((arr[j] > arr[j - 1] && arr[j - 1] > arr[j - 2]) ||
                (arr[j] < arr[j - 1] && arr[j - 1] < arr[j - 2]))
                    i = j - 1;
        }
        max = Math.max(max, j - i + 1);
    }
    return max;
};
