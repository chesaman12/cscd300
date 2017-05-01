package roundRobin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_RoundRobin {
	public static void main(String[] args) throws FileNotFoundException{
		//args[0] = file args[1] = size to decrease by
		Scanner scan = null;
		scan = new Scanner(new File(args[0]));
		Scanner kb = null; 
		kb = new Scanner(new File(args[0]));
		int id; int time; String temp; String[] str;
		CircularLinkedList list = new CircularLinkedList();
		
		while(scan.hasNext()){ //3, 21
			temp = kb.nextLine();
			str = temp.split(", ");
			list.insert(id = Integer.parseInt(str[0]), time = Integer.parseInt(str[1]));
			scan.nextLine();
		}
		scan.close();
		kb.close();
		Node prev = list.head;
		list.head = list.head.next;
		
		while(prev.id < list.head.id){
			prev = list.head;
			list.head = list.head.next;
		}
		
		for(int ix = 0; ix < list.size; ix++){
			System.out.println(list.head.id + " " +list.head.time);
			list.head = list.head.next;
		}
		
		//roundMinus(args[1]);
		
	}

}

	

