// LeetCode 556. Next Greater Element III
// https://leetcode.com/problems/next-greater-element-iii/
// O(dlogd) time, O(d) space, where d is number of digits
class Solution {
    public int nextGreaterElement(int n) {
        char c[] = Integer.toString(n).toCharArray();
        int i = c.length - 1, j = i;
        for (; i >= 0; i--) {
            if (c[i] > c[j])
                j = i;
            else if (c[i] < c[j]) {
                int jj = j;
                for (int ii = c.length - 1; ii > i; ii--)
                    if (c[ii] > c[i] && c[ii] < c[jj])
                        jj = ii;
                j = jj;
                c[i] ^= c[j];
                c[j] ^= c[i];
                c[i] ^= c[j];
                Arrays.sort(c, i + 1, c.length);
                break;
            }
        }
        try {
            Integer d = new Integer(new String(c));
            return d > n ? d : -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
