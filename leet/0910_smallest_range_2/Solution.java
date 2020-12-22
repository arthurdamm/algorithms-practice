// LeetCode 910. Smallest Range II
// O(nlogn) time, O(1) space
class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int ret = A[A.length - 1] - A[0];
        for (int i = 0; i < A.length - 1; i++) {
            int min = Math.min(A[0] + K, A[i + 1] - K);
            int max = Math.max(A[i] + K, A[A.length - 1] - K);
            ret = Math.min(ret, max - min);
        }
        return ret;
    }
}
