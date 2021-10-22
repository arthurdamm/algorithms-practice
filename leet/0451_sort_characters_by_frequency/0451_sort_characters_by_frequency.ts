// LeetCode 451. Sort Characters By Frequency
// https://leetcode.com/problems/sort-characters-by-frequency/
// O(nlogn) time, O(n) space
function frequencySort(s: string): string {
    const counts = s.split('').reduce((cts, c) => (cts[c] = cts[c] + 1 || 1, cts), {});
    return Object.keys(counts).sort((a,b) => counts[b] - counts[a])
        .map(c => c.repeat(counts[c])).join('');
};
