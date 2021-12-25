// LeetCode 227. Basic Calculator II
// https://leetcode.com/problems/basic-calculator-ii/
// O(n) time-and-space
function calculate(s: string): number {
    const numStack = [], operatorStack = [];
    let num = 0;
    const maybeApplyPriorityOperator = () => {
        if (operatorStack.length) {
            switch (operatorStack[operatorStack.length - 1]) {
                case "*" :
                    num = numStack.pop() * num;
                    operatorStack.pop();
                    break;
                case "/" :
                    num = Math.floor(numStack.pop() / num);
                    operatorStack.pop();
                    break;
            }
        }
        numStack.push(num);
        num = 0;
    }
    for (const c of s) {
        if (c >= '0' && c <= '9') {
            num = num * 10 + parseInt(c);
        } else if (c !== ' ') {
            maybeApplyPriorityOperator();
            operatorStack.push(c);
        }
    }
    maybeApplyPriorityOperator();
    numStack.reverse();
    operatorStack.reverse();
    while (operatorStack.length) {
        const op = operatorStack.pop();
        if (op === '+') {
            numStack.push(numStack.pop() + numStack.pop());
        } else {
            numStack.push(numStack.pop() - numStack.pop());
        }
    }
    return numStack.pop();
};
