import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<List<Integer>> solutions = new ArrayList<>();
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(new ArrayList<Integer>(), 1, n);
        return this.solutions;
    }
    
    private void dfs(List<Integer> nums, int i, int target)
    {
        if (nums.size() == this.k) {
            if (target == 0)
                this.solutions.add(new ArrayList<Integer>(nums));
            return;
        }
        if (target < 0) return;
        for (; i <= 9; i++) {
            nums.add(i);
            dfs(nums, i + 1, target - i);
            nums.remove(nums.size() - 1);
        }
    }   
}

public class CombinationSum3a {
    public static void main(String args[]) {
        List<List<Integer>> solutions = new Solution().combinationSum3(3, 15);
    }
}

