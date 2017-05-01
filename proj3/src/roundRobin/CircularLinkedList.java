package roundRobin;

public class CircularLinkedList{
	public int size;
	public Node head;
	public Node prev;

public CircularLinkedList(){
	size = 0;
	head = null;
}
	
//add first	
public void addFirst(int id, int time){
	//pre conditions
	Node nn = new Node(null, id, time);
	this.head = nn;
	nn.next = nn;
	size++;
}

public void insert(int id, int time){//insert and sort on the fly
	Node nn = new Node(null, id, time);
	if(this.head == null){ //first node to add
		addFirst(id,time);
	
	}else if(this.head.next == this.head){ //2nd node to add
		//if(nn.id > this.head.id){         
			addAfter(nn);//add nn after head
		//}else{
			//addBefore(nn);//add nn before head
		//}
	}else{
		//Node cur = this.head;
		boolean bool = true;
		while(bool){//after 2nd node
		
			if(nn.id > head.id && nn.id < head.next.id){//between 2 nodes that arent the lowest or highest

				addAfter(nn);
				bool = false; 
				//add between cur and cur.next
			}else if(this.head.id < this.head.next.id){  //between first and last element
				//if(nn.id > this.head.id){ //1 2 3 4

					addAfter(nn);
					bool = false;
				//}
					
			}else{
				head = head.next;
			}
		}
	}
}

public void addBefore(Node v) {//add before
	if(v == null){
		return; //throw exception
	}
	if(size <= 1){
		addAfter(v);
	}else{
		Node cur;
		for(cur = head.next; cur.next != null; cur = cur.next){};
		v.next = head;
		cur.next = v;
		size++;
	}
}

public void addAfter(Node v) {//add after
	if(v == null){
		return; //throw exception
	}
	v.next = head.next;
	head.next = v;
	size++;
	
}

public void roundMinus(int sub){
	Node cur = this.head;
	if(cur.next == null){
		
		System.out.println(cur.id);
		//remove cur
	}
	while(cur.next!= null){
		cur.id = cur.id - sub;
		if(cur.id <= 0){
			
			System.out.println(cur.id);
			//remove cur
			cur = cur.next;
		}else{
			cur = cur.next;
		}
		
	}
}

public void removeBefore () {
	  if (size == 0) return;
	  if (size == 1) {
	   head = null;
	   size --;
	  }
	  else if (size == 2) removeAfter();
	  else {
	   Node cur;
	   for (cur = head.next; cur.next.next != head; cur = cur.next)
	    ;
	   cur.next = this.head;
	   size --;
	  }
	 }

public void removeAfter() {
	
	
}

}
