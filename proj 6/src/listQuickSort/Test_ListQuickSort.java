package listQuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_ListQuickSort {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = null;
		scan = new Scanner(new File(args[0]));
		Scanner kb = null;
		kb = new Scanner(new File(args[0]));
		String temp;
		int count = 0;
		QuickSortDLinkedList list = new QuickSortDLinkedList();// makes a new
																// list object

		while (scan.hasNext()) {
			temp = kb.nextLine();
			list.addLast(Integer.parseInt(temp));
			scan.nextLine();
			count++;
		}
		scan.close();
		kb.close();

		list.QuickSort(list.head.next, list.tail.prev);
		
		Node cur = list.head;
		for (int ix = 0; ix < count; ix++) {
			cur = cur.next;
			System.out.println(cur.data);
		}
	}
}
