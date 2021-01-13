// LeetCode 881. Boats to Save People
// https://leetcode.com/problems/boats-to-save-people/
// O(nlogn) time O(1) space
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0, i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit)
                i++;
            j--;
            boats++;
        }
        return boats;
    }
}

// O(n) time O(1) space
class SolutionBuckets {
    public int numRescueBoats(int[] people, int limit) {
        int buckets[] = new int[30001];
        int boats = 0, i = 1, j = buckets.length - 1;
        for (int person : people)
            buckets[person]++;
        for (; j >= limit; j--)
            boats += buckets[j];
        while (true) {
            while (i < buckets.length && buckets[i] <= 0)
                i++;
            while (j >= 0 && buckets[j] <= 0)
                j--;
            if (i + j <= limit && i < buckets.length)
                buckets[i]--;
            if (j >= 0)
                buckets[j]--;
            if (i > j)
                break;
            boats++;
        }
        return boats;
    }
}
