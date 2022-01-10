// LeetCode 67. Add Binary
// https://leetcode.com/problems/add-binary/
// O(n) time-and-space
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder c = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int aDigit = 0, bDigit = 0;
            if (i >= 0)
                aDigit = a.charAt(i--) - '0';
            if (j >= 0)
                bDigit = b.charAt(j--) - '0';
            c.append((aDigit + bDigit + carry) % 2);
            carry = (aDigit + bDigit + carry) / 2;
        }
        if (carry == 1)
            c.append('1');
        return c.reverse().toString();
            

    }
}
