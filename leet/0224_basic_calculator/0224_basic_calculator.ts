// LeetCode 224. Basic Calculator
// https://leetcode.com/problems/basic-calculator/
// O(n) time, O(1) space
function calculate(s: string): number {
    function calculateAtIndex(s: string, i: number): {value: number; stopIndex: number} {
        let num = 0, sign = 1, value = 0;
        for (i; i < s.length; i++) {
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + parseInt(s[i]);
            }
            if ("+-()".includes(s[i]) || i === s.length - 1) {
                if (s[i] === ')') {
                    value += sign * num;
                    return {value, stopIndex: i};
                } else if (s[i] === '(') {
                    const ret = calculateAtIndex(s, i + 1);
                    i = ret.stopIndex;
                    value += sign * ret.value;
                } else if (s[i] === "+") {
                    value += sign * num;
                    sign = 1;                    
                } else {
                    value += sign * num;
                    sign = -1;
                }
                num = 0;
            }
        }
        return {value, stopIndex: i};
    }
    return calculateAtIndex(s, 0).value;
};
