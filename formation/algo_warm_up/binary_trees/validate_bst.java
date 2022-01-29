// https://www.algoexpert.io/questions/Validate%20BST

import java.util.*;

class Program {
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return validateBstHelper(tree.left, null, tree.value) &&
			validateBstHelper(tree.right, tree.value, null);
  }
	
	private static boolean validateBstHelper(BST tree, Integer min, Integer max) {
		if (tree == null)
			return true;
		if (min != null && tree.value < min)
			return false;
		if (max != null && tree.value >= max)
			return false;
		return validateBstHelper(tree.left, min, tree.value) &&
			validateBstHelper(tree.right, tree.value, max);
	}

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}


