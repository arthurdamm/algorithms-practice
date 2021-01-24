// LeetCode 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// O(n) time-and-space
class Solution {
    public String minRemoveToMakeValid(String s) {
        char str[] = s.toCharArray();
        Stack<Integer> removeLefts = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(')
                removeLefts.push(i);
            else if (str[i] == ')') {
                if (removeLefts.isEmpty())
                    str[i] = 0;
                else
                    removeLefts.pop();
            }
        }
        for (var i : removeLefts)
            str[i] = 0;
        return new String(str).replaceAll("\0", "");
    }
}
