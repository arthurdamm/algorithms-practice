class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, int[]> seen = new HashMap<Integer, int[]>();
        int[] bucket[2];
        for (int i = 0; i < nums.length; i++)
        {
            j = nums[i] / (t + 1);

            if (bucket = seen.getOrDefault(j, null) != null && i - bucket[1] <= k)
                    return true;
            if (bucket = seen.getOrDefault(j - 1, null) != null && i - bucket[1] <= k &&
                Math.abs(bucket[0] - nums[i]) <= k)
                    return true;
            if (bucket = seen.getOrDefault(j + 1, null) != null && i - bucket[1] <= k &&
                Math.abs(bucket[0] - nums[i]) <= k)
                    return true;
            bucket[0] = nums[i];
            bucket[1] = i;
            seen.put(bucket);
        }
        return false;
    }
}