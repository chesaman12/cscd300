package listQuickSort;

public class QuickSortDLinkedList {
	public int size;
	public Node head;
	public Node tail;

	public QuickSortDLinkedList() {
		size = 0;
		head = new Node(null, null, null);
		tail = new Node(null, null, null);
		head.setNext(tail);
		tail.setPrev(head);
	}

	public void addLast(int num) {// Adds the next num in the list
		Node nn = new Node(null, null, num);

		nn.setPrev(tail.getPrev());
		nn.setNext(tail);
		tail.getPrev().setNext(nn);
		tail.setPrev(nn);
		size++;
	}

	public void QuickSort(Node left, Node right) {
		if (left == right) {
			// DO nothing
		} else {
			Node[] indicies = partition(left, right);
			Node pivot_index = indicies[0];
			left = indicies[1];
			right = indicies[2];
			if (pivot_index != left) {
				QuickSort(left, pivot_index.prev);
			}
			if (pivot_index != right) {
				QuickSort(pivot_index.next, right);
			}
		}
	}

	public Node[] partition(Node one, Node two) {
		Node index = null;
		Node pivot = null;
		if (two.data == null) {
			pivot = two.prev;
		} else {
			pivot = two;
		}
		if (one.data == null) {
			index = one.next;
		} else {
			index = one;
		}
		Node left = index;
		Node right = pivot;
		for (Node i = left.next; i != right; i = i.next) {
			if (i == right) {
				// return;
			} else {
				if (index.data.compareTo(i.data) > 0 && i.data.compareTo(pivot.data) < 0) {
					if (index == left) {
						left = i;
					}
					swap(index, i);
					Node temp = i;
					i = index;
					index = temp;
					index = index.next;

				}
			}

			// left = left.next;
		}
		//if(left.data.compareTo(pivot.data) < 0){
		//System.out.println(index.data + " " +pivot.data);
		Node cur = head;
		/*for (int ix = 0; ix < size; ix++) {
			cur = cur.next;
			System.out.println(cur.data);
		}*/
			swap(index, pivot);
			

			if (index == left) {
				left = pivot;
			}
		//}test
		right = index;
		Node[] segments = new Node[] { pivot, left, right };
		return segments;
	}

	public void swap(Node pos1, Node pos2) {
		if (pos1 == null || pos2 == null || pos1.data == null || pos2.data == null) {
			return;
		} else {

			if (pos1.getNext() == pos2) {
				//System.out.println("pos1 " + pos1.data + " pos2 " + pos2.data);
				Node before = pos1.prev;
				Node after = pos2.next;

				before.next = pos2;
				pos1.next = after;
				pos2.next = pos1;
				after.prev = pos1;
				pos1.prev = pos2;
				pos2.prev = before;

			} else {
				//System.out.println("pos1 " + pos1.data + " pos2 " + pos2.data);
				Node before_one = pos1.prev;
				Node after_one = pos1.next;
				Node before_two = pos2.prev;
				Node after_two = pos2.next;

				pos1.prev = pos2.prev;
				before_one.next = pos2;
				pos1.next = after_two;
				after_one.prev = pos2;
				pos2.prev = before_one;
				before_two.next = pos1;
				pos2.next = after_one;
				after_two.prev = pos1;
			}
		}
	}

}
