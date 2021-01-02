// 1640. Check Array Formation Through Concatenation
// https://leetcode.com/problems/check-array-formation-through-concatenation/
// O(n) time O(n) space
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        int i = 0;

        for (int[] piece: pieces)
            map.put(piece[0], piece);
        while (i < arr.length) {
            int[] piece = map.getOrDefault(arr[i], null);
            if (piece == null)
                return false;
            for (int j = 0; j < piece.length; j++, i++)
                if (piece[j] != arr[i])
                    return false;
        }
        return true;
    }
}
