// LeetCode 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/
// O(n) time-and-space
class Solution {
    Map<Character, Character> closingToOpening = new HashMap<>();
    String parentheses = "()[]{}";
    Solution() {
        for (int i = 1; i < parentheses.length(); i += 2)
            closingToOpening.put(parentheses.charAt(i),
                                 parentheses.charAt(i - 1));
    }
    
    public boolean isValid(String s) {    
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            char opening = closingToOpening.getOrDefault(c, (char)0);
            if (opening != 0) { 
                if (stack.isEmpty() || stack.pop() != opening)
                    return false;
            } else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
