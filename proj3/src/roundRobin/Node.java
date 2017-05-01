package roundRobin;

public class Node{
	public Node next;
	public int id;
	public int time;
	
	public Node(Node next, int id, int time){
		this.next = next;
		this.id = id;
		this.time = time;
	}
}
