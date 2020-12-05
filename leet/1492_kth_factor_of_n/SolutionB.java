// LeetCode 1492. The kth Factor of n
// O(root(n)) time, O(1) space
class Solution {
    public int kthFactor(int n, int k) {
        double root = Math.sqrt(n);
        for (int i = 1; i < root; i++)
            if (n % i == 0 && --k == 0)
                return i;
        for (int i = (int)root; i > 0; i--)
            if (n % i == 0 && --k == 0)
                return n / i;
        return -1;
    }
}
