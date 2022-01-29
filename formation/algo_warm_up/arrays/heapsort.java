// LeetCode 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/
// O(nlogn) time, O(1) space HEAPSORT
class Solution {
    public int[] sortArray(int[] nums) {
        heapsort(nums);
        return nums;
    }
    
    void heapsort(int[] A) {
        heapify(A);
        int end = A.length - 1;
        while (end >= 0) {
            swap(A, 0, end--);
            siftDown(A, 0, end);
        }
    }
    
    void heapify(int[] A) {
        int start = iParent(A.length - 1);
        while (start >= 0)
            siftDown(A, start--, A.length - 1);
    }
    
    void siftDown(int[] A, int start, int end) {
        int root = start;
        while (iLeftChild(root) <= end) {
            int child = iLeftChild(root);
            int swap = root;
            if (A[child] > A[swap])
                swap = child;
            if (child + 1 <= end && A[child + 1] > A[swap])
                swap = child + 1;
            if (root == swap)
                return;
            swap(A, root, swap);
            root = swap;
        }
    }
        
    int iLeftChild(int i) {
        return i * 2 + 1;
    }
    
    int iParent(int i) {
        return (i - 1) / 2;
    }

    void swap(int []A, int i, int j) {
        if (i == j) return;
        A[i] ^= A[j];
        A[j] ^= A[i];
        A[i] ^= A[j];
    }
}
