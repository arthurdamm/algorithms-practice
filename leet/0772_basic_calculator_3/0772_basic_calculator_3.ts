// LeetCode 772. Basic Calculator III
// https://leetcode.com/problems/basic-calculator-iii/
// O(n) time-and-space
function calculate(s: string): number {
    function calculateAtIndex(s: string, i: number): {value: number; stopIndex: number} {
        let num = 0, numStack = [], op = "+";
        for (i; i < s.length; i++) {
            let ret = {value: 0, stopIndex: i};
            if (s[i] >= '0' && s[i] <= '9') {
                num = num * 10 + parseInt(s[i]);
            } else if (s[i] === '(') {
                ret = calculateAtIndex(s, i + 1);
                i = ret.stopIndex + 1;
                num = ret.value;
            }
            if ("+-*/)".includes(s[i]) || i >= s.length - 1) {
                if (op === "+") {
                    numStack.push(num);
                } else if(op === '-') {
                    numStack.push(-num);
                } else if(op === '*') {
                    numStack.push(numStack.pop() * num)
                } else if(op === '/') {
                    numStack.push(Math.trunc(numStack.pop() / num));
                }
                if (s[i] === ')') {
                    return {value: numStack.reduce((a,b) => a + b), stopIndex: i};
                }
                op = s[i];
                num = 0;
            }
        }
        return {value: numStack.reduce((a,b) => a + b), stopIndex: i};
    }
    return calculateAtIndex(s, 0).value;
};
