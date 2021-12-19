// LeetCode 394. Decode String
// https://leetcode.com/problems/decode-string/
// O(n) time-and-space;
function decodeString(s: string): string {
    const substrStack = [], numStack = [];
    let num = 0, substr = '';
    for (const c of s) {
        if (c >= '0' && c <= '9') {
            num = num * 10 + parseInt(c);
        } else if (c === '[') {
            numStack.push(num);
            num = 0;
            substrStack.push(substr);
            substr = '';
        } else if (c === ']') {
            substr = substrStack.pop() + substr.repeat(numStack.pop());
        } else {
            substr += c;
        }
    }
    return substr;
};
