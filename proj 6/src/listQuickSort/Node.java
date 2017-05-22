package listQuickSort;

public class Node {
	public Comparable data;
	public Node next;
	public Node prev;

	public Node(Node next, Node prev, Comparable num) {
		this.data = num;
		this.next = next;
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
