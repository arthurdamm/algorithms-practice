// 1640. Check Array Formation Through Concatenation
// https://leetcode.com/problems/check-array-formation-through-concatenation/
// O(n) time O(n) space
class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        unordered_map<int, vector<int>> map;
        int i = 0;

        for (auto piece : pieces)
            map[piece[0]] = piece;
        while (i < arr.size()) {
            vector<int> piece = map[arr[i]];
            if (piece.empty())
                return false;
            for (int j = 0; j < piece.size(); j++, i++)
                if (arr[i] != piece[j])
                    return false;
        }
        return true;
    }
};
