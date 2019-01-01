package codes;

public class LLTester {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.push(6);
		
		//ll.display();
		
		//System.out.println(ll.pop(3));
		
		//ll.display();
		
		//System.out.println(ll.find(1));
		//System.out.println(ll.find(2));
		
		ll.swap(ll.find(5),ll.find(6));
		
		ll.display();
	} // end main

} // end class LLTester
