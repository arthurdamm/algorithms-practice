// LeetCode 821. Shortest Distance to a Character
// https://leetcode.com/problems/shortest-distance-to-a-character/
// O(n) time-and-space
function shortestToChar(s: string, c: string): number[] {
    let nearestRight = new Array(s.length).fill(0);
    let nearestLeft = new Array(s.length).fill(0);
    let nearest = Number.MIN_SAFE_INTEGER;
    nearestLeft = nearestLeft.map((l, i) => ((s[i] === c ? nearest = i : 0), nearest));
    nearest = Number.MAX_SAFE_INTEGER;
    for (let i = s.length - 1; i >= 0; i--) {
        if (s[i] === c)
            nearest = i;
        nearestRight[i] = nearest;
    }
    return nearestLeft.map((l, i) => Math.min(i - nearestLeft[i], nearestRight[i] - i));
};
