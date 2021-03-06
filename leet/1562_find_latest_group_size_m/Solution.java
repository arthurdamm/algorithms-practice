// LeetCode 1562. Find Latest Group of Size M
// https://leetcode.com/problems/find-latest-group-of-size-m/
// O(nlogn) time, O(n) space
class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m)
            return m;
        TreeSet<Integer[]> tree = new TreeSet<>((a,b)->a[0] - b[0]);
        tree.add(new Integer[]{1, arr.length});
        Integer[] temp = new Integer[2];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[0] = arr[i];
            Integer[] a = tree.floor(temp);
            Integer[] b = new Integer[]{arr[i] + 1, a[1]};
            a[1] = arr[i] - 1;
            if (a[1] - a[0] + 1 == m || b[1] - b[0] + 1 == m)
                return i;
            tree.add(b);
        }
        return -1;
    }
}

// O(n) time, O(n) space
class SolutionMapIntervals {
    public int findLatestStep(int[] arr, int m) {
        int lens[] = new int[arr.length + 1], sets[] = new int[arr.length + 2], ret = -1;
        for (int i = 0; i < arr.length; i++) {
            int left = sets[arr[i] - 1], right = sets[arr[i] + 1];
            int len = left + right + 1;
            sets[arr[i] + right] = sets[arr[i] - left] = len;
            lens[len]++;
            lens[left]--;
            lens[right]--;
            if (lens[m] > 0)
                ret = i + 1;
        }
        return ret;
    }
}
