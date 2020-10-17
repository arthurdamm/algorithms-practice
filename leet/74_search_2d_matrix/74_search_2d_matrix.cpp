// LeetCode 74. Search a 2D Matrix
// (Ologn) time, O(1) space

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int lo = 0, hi = matrix.size() - 1, mid = 0;
        
        if (matrix.size() == 0 || matrix[0].size() == 0)
            return false;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] < target)
                lo = mid + 1;
            else if (matrix[mid][0] > target)
                hi = mid - 1;
            else
                break;
        }
        if (matrix[mid][0] > target) {
            mid--;
            if (mid < 0)
                return false;
        }
        vector<int>& row = matrix[mid];
        lo = 0, hi = row.size() - 1, mid = 0;
        
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (row[mid] < target)
                lo = mid + 1;
            else if (row[mid] > target)
                hi = mid - 1;
            else
                return true;
        }
        return false;
    }
};
