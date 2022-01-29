// https://www.algoexpert.io/questions/Linked%20List%20Construction

import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
			if (node == null) return;
      remove(node);
			if (head != null) {
				node.next = head;
				head.prev = node;
			} else
				tail = node;
			head = node;
    }

    public void setTail(Node node) {
			if (node == null) return;
      remove(node);
			if (tail != null) {
				node.prev = tail;
				tail.next = node;
			} else
				head = node;
			tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
    	if (node == null || nodeToInsert == null) return;
			remove(nodeToInsert);
			if (node == head) {
				setHead(nodeToInsert);
				return;
			}
			node.prev.next = nodeToInsert;
			nodeToInsert.prev = node.prev;
			node.prev = nodeToInsert;
			nodeToInsert.next = node;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      if (node == null || nodeToInsert == null) return;
			remove(nodeToInsert);
			if (node == tail) {
				setTail(nodeToInsert);
				return;
			}
			if (node.next != null)
				node.next.prev = nodeToInsert;
			nodeToInsert.next = node.next;
			node.next = nodeToInsert;
			nodeToInsert.prev = node;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
			if (nodeToInsert == null) return;
      if (position <= 1) {
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			for (int i = 1; node.next != null && i + 1 < position; i++)
				node = node.next;
			if (node != nodeToInsert) {
				remove(nodeToInsert);
				insertAfter(node, nodeToInsert);
			}
    }

    public void removeNodesWithValue(int value) {
      Node node = head;
			while (node != null) {
				if (node.value == value) {
					Node temp = node.next;
					remove(node);
					node = temp;
				} else
					node = node.next;
			}
    }

    public void remove(Node node) {
			if (node == null) return;
      if (node == tail)
				tail = node.prev;
			if (node == head)
				head = node.next;
			if (node.prev != null)
				node.prev.next = node.next;
			if (node.next != null)
				node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
    }

    public boolean containsNodeWithValue(int value) {
      Node node = head;
			while (node != null) {
				if (node.value == value)
					return true;
				node = node.next;
			}
      return false;
    }
		
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}


