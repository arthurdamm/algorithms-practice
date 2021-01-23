// LeetCode 150. Evaluate Reverse Polish Notation
// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// O(n) time-and-space
var evalRPN = function(tokens) {
    let operations = {
        "+": (a, b) => b + a,
        "-": (a, b) => b - a,
        "*": (a, b) => b * a,
        "/": (a, b) => parseInt(b / a),
    };
    let stack = [];
    for (let token of tokens)
        if (operations[token])
            stack.push(operations[token](stack.pop(), stack.pop()));
        else
            stack.push(parseInt(token));
    return stack.pop();
};
