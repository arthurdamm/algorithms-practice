// https://www.algoexpert.io/questions/Remove%20Kth%20Node%20From%20End
import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
		LinkedList slow = head, fast = head;
    for (int i = 0; i < k; i++)
			fast = fast.next;
		if (fast == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}


