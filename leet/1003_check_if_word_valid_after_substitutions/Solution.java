// LeetCode 1003. Check If Word Is Valid After Substitutions
// https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
// O(n) time-and-space
class Solution {
    public boolean isValid(String s) {
        Stack<Character> s1 = new Stack<>(), s2 = new Stack<>();
        char str[] = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            while (s1.size() > i)
                s2.push(s1.pop());
            if (s1.size() == i || s1.peek() != str[i]) {
                if (str[i] == 'a') {
                    s1.push('a');
                    s1.push('b');
                    s1.push('c');
                } else {
                    if (s2.isEmpty() || s2.peek() != str[i])
                        return false;
                    s1.push(s2.pop());
                }
            }
        }
        return s2.isEmpty();
    }
}
