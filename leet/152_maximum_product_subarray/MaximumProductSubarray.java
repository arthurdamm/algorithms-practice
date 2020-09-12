class Solution {
    public int maxProduct(int[] nums) {
        int max = java.lang.Integer.MIN_VALUE, n = 1, i;
        for (i = 0; i < nums.length; i++)
        {
            n *= nums[i];
            max = Math.max(max, Math.max(n, nums[i]));
            if (n == 0)
                n = 1;
        }
        n = 1;
        for (i = nums.length - 1; i >= 0; i--) {
            n *= nums[i];
            max = Math.max(max, Math.max(n, nums[i]));
            if (n == 0)
                n = 1;
        }
        return max;
    }
}

public class MaximumProductSubarray {
    public static void main(String args[]) {
        int arr[] = {1, -2, -3, 0, 5};
        int ret = new Solution().maxProduct(arr);
        System.out.println("Solution: " + ret);
    }
}

