// https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
		int closest = tree.value;
    while (tree != null) {
			if (tree.value == target)
				return target;
			if (Math.abs(tree.value - target) < Math.abs(closest - target))
				closest = tree.value;
			if (target > tree.value)
				tree = tree.right;
			else
				tree = tree.left;
		}
		return closest;
    
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


