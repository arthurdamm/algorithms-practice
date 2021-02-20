// LeetCode 13. Roman to Integer
// https://leetcode.com/problems/roman-to-integer/
// O(n) time, O(1) space
function romanToInt(s: string): number {
        const mapDigit = {"I": 1, "V": 5, "X": 10, "L": 50, "C":100, "D": 500, "M":1000};
        let num = 0;
        for (let i = s.length - 1; i >= 0; i--) {
            if (i < s.length - 1 && mapDigit[s[i]] < mapDigit[s[i + 1]])
                num -= mapDigit[s[i]];
            else
                num += mapDigit[s[i]];
        }
        return num;
};
