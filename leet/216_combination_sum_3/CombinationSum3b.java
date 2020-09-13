import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private List<List<Integer>> solutions = new ArrayList<>();
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        Integer _choices[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> choices = new ArrayList<Integer>(Arrays.asList(_choices));
        dfs(choices, 0, new ArrayList<Integer>(), n); 
        return this.solutions;
    }   
    
    private void dfs(List<Integer> choices, int i, List<Integer> nums, int target)
    {   
        if (target < 0) return;
        if (nums.size() == this.k) {
            if (target == 0)
                this.solutions.add(new ArrayList<Integer>(nums));
            return;
        }   
        for (; i < choices.size(); i++)
        {   
            nums.add(choices.get(i));
            dfs(choices, i + 1, nums, target - choices.get(i));
            nums.remove(nums.size() - 1); 
        }
    }   
}

public class CombinationSum3b {
    public static void main(String args[]) {
        List<List<Integer>> solutions = new Solution().combinationSum3(3, 15);
    }
}

