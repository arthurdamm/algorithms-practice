// LeetCode 526. Beautiful Arrangement
// https://leetcode.com/problems/beautiful-arrangement/
// O(k!) time O(1) space
class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;
        dfs(nums, n - 1);
        return count;
    }
    
    void dfs(int nums[], int i) {
        if (i < 0) {
            count++;
            return;
        }
        for (int j = i; j >= 0; j--) {
            if (nums[j] % (i + 1) != 0 && (i + 1) % nums[j] != 0)
                continue;
            int temp = nums[j];
            nums[j] = nums[i];
            dfs(nums, i - 1);
            nums[j] = temp;
        }
    }
}
