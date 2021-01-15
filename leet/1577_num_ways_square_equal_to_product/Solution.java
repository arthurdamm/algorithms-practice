// LeetCode 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
// https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/
// O(n*m) time O(n+m) space
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set1 = new HashMap<>(), set2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            set1.put(nums1[i], set1.getOrDefault(nums1[i], 0) + 1);
        for (int i = 0; i < nums2.length; i++)
            set2.put(nums2[i], set2.getOrDefault(nums2[i], 0) + 1);
        double count = 0;
        for (int i = 0; i < nums1.length; i++) {
            long num1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                long num2 = nums2[j];                
                if (num1 * num1 % num2 == 0 && set2.containsKey((int)(num1 * num1 / num2))) {
                    int c = set2.get((int)(num1 * num1 / num2));
                    if (num1 != num2 || c > 1) {
                        if (num1 != num2)
                            c++;
                        double pairs = c * (c - 1) / 2;
                        count += pairs / c;
                    }
                        
                }
                if (num2 * num2 % num1 == 0 && set1.containsKey((int)(num2 * num2 / num1))) {
                    int c = set1.get((int)(num2 * num2 / num1));
                    if (num1 != num2 || c > 1) {
                        if (num1 != num2)
                            c++;
                        double pairs = c * (c - 1) / 2;
                        count += pairs / c;
                    }
                }
                
            }
        }
        return (int)count;
    }
}
