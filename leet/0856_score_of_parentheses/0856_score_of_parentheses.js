// LeetCode 856. Score of Parentheses
// https://leetcode.com/problems/score-of-parentheses/
// O(n) time-and-space
var scoreOfParentheses = function(S) {
    stack = [];
    for (let c of S) {
        if (c !== "(") {
            let top = stack.pop();
            c = (top == "(" ? 1 : top * 2);
            if (c != 1)
                stack.pop();
            if (typeof stack[stack.length - 1] === "number")
                c += stack.pop();
        }
        stack.push(c);
    }
    return stack.pop();
};
