// https://www.algoexpert.io/questions/Branch%20Sums

import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

	static List<Integer> result;
		
  public static List<Integer> branchSums(BinaryTree root) {
		result = new ArrayList<Integer>();
		if (root != null)
    	dfs(root, 0);
		return result;
  }
	
	private static void dfs(BinaryTree root, int sum) {
		sum += root.value;
		if (root.left == null && root.right == null) {
			result.add(sum);
			return;
		}
		if (root.left != null)
			dfs(root.left, sum);
		if (root.right != null)
			dfs(root.right, sum);
	}
}


