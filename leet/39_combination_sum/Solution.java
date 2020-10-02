import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	//List<Integer> currList = new ArrayList<>();
	List<List<Integer>> solutions = new ArrayList<>();
	Set<String> set = new HashSet<>();

	public static void p(Object o) { System.out.println(o); }
	public static void main(String args[]) {
		int[] input1 = {2,3,6,7};
		int target1 = 7;
		int[] input2 = {2,3,5};
		int target2 = 7;
		int[] input3 = {1};
		int target3 = 1;
		Solution sol = new Solution();
		for (List<Integer> l : sol.combinationSum(input2, target2)) {
			p(Arrays.toString(l.toArray()));
		}
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	for (int i = 0; i < candidates.length; i++)
	    	dfs(candidates, target, i, new ArrayList<Integer>());
	    //dfs(candidates, target, 0, new ArrayList<Integer>());
    	return solutions;
    }

    void dfs(int[] candidates, int target, int i, List<Integer> currList) {
    	p("DFS " + target + " : " + i + " : " + Arrays.toString(currList.toArray()));
    	if (target < 0)
    		return;
    	if (target == 0) {
    		String s = Arrays.toString(currList.toArray());
    		if (set.contains(s))
    			return;
    		set.add(s);
    		p("ADDING: " + s);
    		this.solutions.add(new ArrayList<>(currList));
    		return;
    	}
    	if (i <= candidates.length - 1) {
	    	currList.add(candidates[i]);
	    	dfs(candidates, target - candidates[i], i, currList);
	    	currList.remove(currList.size() - 1);
	    	if (i < candidates.length - 1) {
	    		List<Integer> currList2 = new ArrayList<>(currList);
	    		//p("CURRLIST2: " + Arrays.toString(currList2.toArray()));
		    	//currList2.add(candidates[i + 1]);
		    	dfs(candidates, target, i + 1, currList2);
		    	//currList2.remove(currList2.size() - 1);
	    	}
    	}
    }
}
