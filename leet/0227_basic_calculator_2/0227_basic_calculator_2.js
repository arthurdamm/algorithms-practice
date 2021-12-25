// LeetCode 227. Basic Calculator II
// https://leetcode.com/problems/basic-calculator-ii/
// O(n) time-and-space 
var calculate = function(s) {
    let num = 0, op = "+";
    const numStack = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i] >= '0' && s[i] <= '9') {
            num = num * 10 + parseInt(s[i]);
        }
        if ("+-*/".includes(s[i]) || i == s.length - 1) {
            if (op === "+") {
                numStack.push(num);
            } else if(op === '-') {
                numStack.push(-num);
            } else if(op === '*') {
                numStack.push(numStack.pop() * num)
            } else if(op === '/') {
                numStack.push(parseInt((numStack.pop() / num).toString()));
            }
            op = s[i];
            num = 0;
        }
    }
    return numStack.reduce((a,b) => a + b);
    
};
