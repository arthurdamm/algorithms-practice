// 858. Mirror Reflection
// O(p) time, O(1) space

class Solution {
    public int mirrorReflection(int p, int q) {
        int x = 1;
        while (q * x % p != 0)
            x++;
        if (x % 2 == 1 && x * q / p % 2 == 1)
            return 1;
        if (x % 2 == 0 && x * q / p % 2 == 1)
            return 2;
        if (x % 2 == 1 && x * q / p % 2 == 0)
            return 0;
        return -1;
    }
}
