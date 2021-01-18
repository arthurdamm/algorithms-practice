// LeetCode 1711. Count Good Meals
// https://leetcode.com/problems/count-good-meals/
// O(n) time, O(n) space
class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> counter = new HashMap<>();
        int meals = 0, MOD = (int)1e9 + 7;
        for (int n : deliciousness)
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        for (var e : counter.entrySet()) {
            for (int pow2 = 1; pow2 <= 2 << 20; pow2 <<= 1) {
                int complement = pow2 - e.getKey();
                if (complement < e.getKey())
                    continue;
                if (complement == e.getKey())
                    meals += ((long)e.getValue() * (e.getValue() - 1) / 2) % MOD;
                else {
                    int complementCount = counter.getOrDefault(complement, 0);
                    if (complementCount > 0)
                        meals += ((long)e.getValue() * complementCount) % MOD;
                }
            }
        }
        return meals;
    }
}
