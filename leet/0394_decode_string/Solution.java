// LeetCode 394. Decode String
// https://leetcode.com/problems/decode-string/
// O(n) time-and-space
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> substrStack = new Stack();
        Stack<Integer> numStack = new Stack();
        StringBuilder substr = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                substrStack.push(substr);
                substr = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                substr = substrStack.pop().append(substr.toString().repeat(numStack.pop()));
            } else {
                substr.append(c);
            }
        }
        return substr.toString();
    }
}
