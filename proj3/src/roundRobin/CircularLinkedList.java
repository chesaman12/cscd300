package roundRobin;

public class CircularLinkedList {
	public int size;
	public Node head;
	public Node tail;
	public Node prev;

public CircularLinkedList(){
	size = 0;
	head = null;
}
	
//add first	
public void addFirst(int id, int time){
	//pre conditions
	Node nn = new Node(null, id, time);
	this.head = this.tail = nn;
	nn.next = nn;
	size++;
}

public void insert(int id, int time){//insert and sort on the fly
	Node nn = new Node(null, id, time);
	if(this.head == null){ //first node to add
		addFirst(id,time);
	
//	}else if(this.head.next == this.head){ //2nd node to add
//		if(nn.id > this.head.id){
//			addAfter(nn);//add nn after head
//		}else{
//			addBefore(nn);//add nn before head
//		}
	}else{
		Node cur = this.head;
		boolean added = false;
		while(!added){//after 2nd node

//			System.out.println(nn.id + ", " + cur.id);

			if(nn.id < head.id){
				head = nn;
				nn.next = cur;
				tail.next = head;
				size++;
				added = true;
			}else if(nn.id > cur.id && (nn.id < cur.next.id || cur.next == head)) {

				if(cur.next == head){
					tail = nn;
				}


				addAfter(cur, nn);



				added = true;
			}

			cur = cur.next;
		}
	}
}

public void addAfter(Node cur, Node nn) {//add after
//	System.out.println("add after: " + cur.id + ", " + nn.id);
	if(nn == null){
		return; //throw exception
	}
	nn.next = cur.next;
	cur.next = nn;
	size++;
}

public void roundMinus(int sub){
	Node cur = this.head;
	if(size == 1){
		
		System.out.println(cur.id);
		//remove cur
	}
	while(size > 0){
		cur.time = cur.time - sub;
		System.out.println(cur);
		if(cur.time <= 0){
			
			System.out.println("removing: " + cur.id);
			remove(cur);
		}

		cur = cur.next;

	}
}

public void remove (Node nr) {
	  if (size == 0) return;
	  if (size == 1) {
	   head = null;
	   size --;
	  }
	  else if(nr == head){
	  	head = tail.next = nr.next;
	  	size --;
	  }
	  else {
	   Node prev = head;

	   while(prev.next != nr){
	   	prev = prev.next;
	   }

	   if(prev.next == tail){
	   	prev.next = head;
	   	tail = prev;
	   }else {
	   	prev.next = nr.next;
	   }

	   size --;
	  }
	 }

public void removeAfter() {
	
	
}

}
