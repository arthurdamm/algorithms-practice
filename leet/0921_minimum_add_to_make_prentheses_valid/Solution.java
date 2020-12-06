// LeetCode 921. Minimum Add to Make Parentheses Valid
// O(n) time O(1) space
class Solution {
    public int minAddToMakeValid(String S) {
        int adds = 0, lefts = 0;
        for (char c : S.toCharArray()) {
            switch (c) {
                case '(':
                    lefts++;
                    break;
                case ')':
                    if (lefts == 0)
                        adds++;
                    else
                        lefts--;
                    break;
            }
        }
        return adds + lefts;
    }
}

