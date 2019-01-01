package codes;

public class LinkedList {

	private Node first;
	private Node last;
	private int length;
	
	public LinkedList() {
		first = null;
		last = null;
		length = 0;
	} // end constructor LinkedList
	
	public void push(int data) { // add node to the end of the list
		Node temp = new Node(data);
		
		if(first == null) { // if the list is empty
			first = temp;
		}
		else {
			temp.setPrev(last);
			last.setNext(temp);
		}
		
		last = temp;
		length++;
	} // end method push
	
	public void display() {
		Node temp = first;
		
		while(temp != null) { // print forward
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		
		System.out.println();
		
		temp = last;
		
		while(temp != null) { // print backward
			System.out.print(temp.getData() + " ");
			temp = temp.getPrev();
		}
		
		System.out.println();
	} // end method display
	
	public int pop() { // remove the last node in the list (stack)
		int temp = -1;
		
		if(first == last) {
			temp = first.getData();
			first = null;
		}
		if(last != null) {
			temp = last.getData();
			last = last.getPrev();
			last.setNext(null);
		}
		
		length--;
		
		return temp;
	} // end method pop
	
	public int pop(int data) {
		Node temp = first;
		Node next;
		Node prev;
		
		for(int counter = 0; counter < length; counter++) {
			if(temp.getData() == data) {
				next = temp.getNext();
				prev = temp.getPrev();
				
				if(temp == first) {
					next.setPrev(null);
					first = next;
				}
				else if(temp == last) {
					prev.setNext(null);
					last = prev;
				}
				else {
					prev.setNext(temp.getNext());
					next.setPrev(temp.getPrev());
				}
				
				length--;
				
				return data;
			}
			else {
				temp = temp.getNext();
			}
		}
		
		return data;
	} // end method pop
	
	public Node find(int data) {
		Node temp = first;
		
		while(temp != null) {
			if(temp.getData() == data) {
				return temp;
			}
			
			temp = temp.getNext();
		}

		return null;
	} // end find
	
	public void swap(Node node1, Node node2) {
		// check if numbers are in the list
		Node temp;
		Boolean inOrder = false;
		Boolean inList1 = false;
		Boolean inList2 = false;
		
		inList1 = inList(node1);
		inList2 = inList(node2);
		
		if(inList1 && inList2) {
			temp = node1;
			
			while(temp != null) {
				if(temp == node2) // if node2 comes after node1
					inOrder = true;
				
				temp = temp.getNext();
			}
			
			if(!inOrder) { // swap placenames
				temp = node1;
				node1 = node2;
				node2 = temp;
			}
			
			///TODO: remove "Case"s
			if(node1.getPrev() == null && node1.getNext() == node2) { // case1 (first, adj middle)
				System.out.println("Case 1");
				
				node2.getNext().setPrev(node1);
				node1.setPrev(node2);
				node2.setPrev(null);
				node1.setNext(node2.getNext());
				node2.setNext(node1);
				
				first = node2;
			}
			else if(node1.getPrev() == null && node2.getNext() == null) { // case3 (first, last)
				System.out.println("Case 2");
				
				node1.setPrev(node2.getPrev());
				node1.getNext().setPrev(node2);
				node2.setNext(node1.getNext());
				node2.getPrev().setNext(node1);
				node2.setPrev(null);
				node1.setNext(null);
				
				first = node2;
				last = node1;
			}
			else if(node1.getPrev() == null && node2.getNext() != null) { // case2 (first, middle)
				System.out.println("Case 3");
				
				node2.getPrev().setNext(node1);
				node2.getNext().setPrev(node1);
				node1.getNext().setPrev(node2);
				
				temp = node1.getNext();
				
				node1.setNext(node2.getNext());
				node2.setNext(temp);
				node1.setPrev(node2.getPrev());
				node2.setPrev(null);
				
				first = node2;
			}
			else if (node1.getNext() == node2 && node2.getNext() != null){ // case4 (middle, adj middle)
				System.out.println("Case 4");
				
				node2.getNext().setPrev(node1);
				node2.setPrev(node1.getPrev());
				node1.getPrev().setNext(node2);
				node1.setNext(node2.getNext());
				node1.setPrev(node2);
				node2.setNext(node1);
			}
			else if(node1.getNext() != node2 && node2.getNext() == null){ // case 6 (middle, last)
				System.out.println("Case 5");
				
				node1.getPrev().setNext(node2);
				node1.getNext().setPrev(node2);
				node2.getPrev().setNext(node1);
				
				temp = node1.getPrev();
				
				node1.setPrev(node2.getPrev());
				node2.setPrev(temp);
				
				node2.setNext(node1.getNext());
				node1.setNext(null);
				
				last = node1;
			}
			else if(node1.getNext() != node2 && node2.getNext() != null){ // case5 (middle, middle)
				System.out.println("Case 6");
				
				node1.getPrev().setNext(node2);
				node2.getPrev().setNext(node1);
				node1.getNext().setPrev(node2);
				node2.getNext().setPrev(node1);
				
				temp = node1.getPrev();
				
				node1.setPrev(node2.getPrev());
				node2.setPrev(temp);
				
				temp = node2.getNext();
				
				node2.setNext(node1.getNext());
				node1.setNext(temp);
			}
			else if(node1.getNext() == node2 && node2.getNext() == null){ // case 7 (adj middle, last)
				System.out.println("Case 7");
				
				node1.getPrev().setNext(node2);
				node2.setPrev(node1.getPrev());
				node2.setNext(node1);
				node1.setPrev(node2);
				
				node1.setNext(null);
				
				last = node1;
			}
		} 
		else { /// TODO: maybe move to LLTester if taking user input (inList())
			System.out.println("Data was not in the list");
		}
	} // end swap
	
	public static boolean inList(Node node) { // check if node is in linkedlist
		Boolean inList = false;
		Node temp = node;
		
		while(temp != null) {
			if(temp == node)
				inList = true;
			
			temp = temp.getNext();
		}
		
		return inList;
	} // end method inList
	
} // end class LinkedList
