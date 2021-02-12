// LeetCode 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/
// O(n) time-and-space
function isAnagram(s: string, t: string): boolean {
    if (s.length != t.length)
        return false;
    const count:Map<number, number> = new Map();
    s.split("")
        .map(s => s.codePointAt(0))
        .reduce((count, c) => count.set(c, (count.get(c)||0) + 1), count);
    t.split("")
        .map(s => s.codePointAt(0))
        .reduce((count, c) => count.set(c, (count.get(c)||0) - 1), count);
    for (let c of count.values())
        if (c != 0)
            return false
    return true;
};
