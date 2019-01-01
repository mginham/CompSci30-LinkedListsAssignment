package codes;

public class Node {

	private int data;
	private Node next; // just assigning a name, not creating a node (therefore, not self-replicating)
	private Node prev;
	
	public Node() {
		
	}
	
	public Node(int data) {
		super(); // inherit from all parent classes
		this.data = data;
	} // end constructor Node
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
} // end class Node
