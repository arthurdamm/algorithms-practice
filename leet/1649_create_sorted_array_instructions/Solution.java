// LeetCode 1649. Create Sorted Array through Instructions
// https://leetcode.com/problems/create-sorted-array-through-instructions/
// O(n*log(max(instructions))) time, O(max(instructions)) space
class Solution {
    public int createSortedArray(int[] instructions) {
        int max = 0;
        for (int instruction : instructions)
            if (instruction > max) max = instruction;
        BinaryIndexedTree bit = new BinaryIndexedTree(max + 1);
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            cost = (cost + Math.min(bit.get(instructions[i] - 1), i - bit.get(instructions[i]))) % 1_000_000_007;
            bit.put(instructions[i], 1);
        }
        return cost;
    }
}
class BinaryIndexedTree {
    private int A[];
    BinaryIndexedTree(int length) {
        A = new int[length];
    }
    int get(int i) {
        int sum = 0;
        for (; i > 0; i -= (i & -i))
            sum += A[i];
        return sum;
    }
    void put(int i, int val) {
        for (; i < A.length; i += (i & -i))
            A[i] += val;
    }
}
