// LeetCode 189. Rotate Array
// O(n) time, O(1) space
class Solution {
    static void p(Object o) { System.out.println(o); }
    int gcf(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a > b) return gcf(a - b, b);
        return gcf(a, b - a);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0)
            return;
        int prev = 0, temp = 0;
        int last_start = 0;
        boolean first_time = true;
        int sz = nums.length + gcf(nums.length, k);
        for (int j = 0, n = 0; n < sz; n++, j += k) {
                j %= nums.length;
                temp = prev;
                prev = nums[j];
                nums[j] = temp;
                if (j == last_start) {
                    if (!first_time) {
                        last_start++;
                        j -= k - 1;
                        first_time = true;
                    } else
                        first_time = false;
                }
        }
    }
}
