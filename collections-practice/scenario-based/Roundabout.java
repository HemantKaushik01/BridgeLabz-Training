package in.senerio;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	String name;
	Node next;
	
	Node(String name){
		this.name = name;
	}
	
}
public class Roundabout {
	private Node head;
	private Node tail;
    private Queue<String> queue = new LinkedList<>();
    private int size =0;
   	final static int maxSize =5;
   	final static int queueMaxSize = 5;
   	
   	
// Add vehicle
    public void add(String name) {
    	Node temp = new Node(name);
    	if(size<maxSize) {
    		if(head==null) {
    			head=tail=temp;
    			tail.next = head;
    		}
    		else {
    			tail.next= temp;
    			tail= temp;
    			tail.next= head;
    		}
    		size++;
    	}
// For overflow
    	else {
    		if(queue.size() == queueMaxSize) {
    		    System.out.println("Traffic diverted");
    		}
    		else {
    			
    			System.out.println("Roundabout full, queue added : "+ name);
    			queue.add(name);
    		}
    	}
    		
    }
  
// remove vehicle
    public void remove(String name) {
    	if(head == null) {
    		System.out.print("Roundabout empty");
    		return ;
    	}
    	Node curr = head;
    	Node prev = tail;
    	boolean found = false;
    	
    	do {
    		if(curr.name.equals(name)) {
    			found = true;
    			break;
    		}
    		prev = curr;
    		curr = curr.next;
    	}while(curr!=head);
    	
    	if(!found) {
    		System.out.println("This vehicle is not present: "+ name);
    		return ;
    	}
    	
    	if(size==1) {
    		head =tail= null;
    	}
    	else if(curr == head) {
    		head = head.next;
    		tail.next = head;
    	}
    	else if(curr == tail) {
    		tail= prev;
    		tail.next=head;
    	}
    	else {
    		prev.next = curr.next;
    	}
    	size--;
    	
    	if(!queue.isEmpty()) {
    		add(queue.poll());
    	}
    	

    	
    	
    }
    public void display() {
    	System.out.println("\nDisplay current senerio of Roundabout\n");
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("Head");
        System.out.println("Current Size of Roundabout: "+size);
        System.out.println("Waiting Queue: "+ queue);
        System.out.println("========================================\n");
    }
	public static void main(String[] args) {
		Roundabout obj = new Roundabout();
		obj.add("a");
		obj.add("b");
		obj.add("c");
		obj.add("d");
		obj.add("e");
		obj.add("f");
		obj.add("g");
		obj.add("h");
		obj.add("i");
		obj.add("j");
		obj.add("k");
		obj.add("l");
		obj.add("m");

		obj.display();
		obj.remove("a");
		obj.remove("c");
        obj.remove("e");
        obj.remove("x");
		obj.display();

		

	}

}
