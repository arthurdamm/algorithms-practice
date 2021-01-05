// LeetCode 567. Permutation in String
// https://leetcode.com/problems/permutation-in-string/
// O(n + m) time, O(1) space
class Solution {
    public boolean checkInclusion(String _s1, String _s2) {
        int c1[] = new int[127], c2[] = new int[127];
        int sum1 = 0, sum2 = 0;
        char s1[] = _s1.toCharArray(), s2[] = _s2.toCharArray();
        for (char c : s1) {
            c1[c]++;
            sum1++;
        }
        for (int i = 0; i < s2.length; i++) {
            if (c1[s2[i]] > 0)
                if (c2[s2[i]]++ < c1[s2[i]])
                    sum2++;
            if (i >= s1.length)
                if (c1[s2[i - s1.length]] > 0)
                    if (--c2[s2[i - s1.length]] < c1[s2[i - s1.length]])
                        sum2--;
            if (sum2 == sum1)
                break;
        }
        return sum2 == sum1;
    }
}
