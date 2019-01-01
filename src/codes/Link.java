/*
 * According to video "Linked List in Java" by Derek Banas
 */
package codes;

public class Link {

	public String bookName;
	public int millionsSold;
	
	public Link next;
	
	public Link(String bookName, int millionsSold) { // object class
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	} // end Link
	
	public void display() { // display method
		System.out.println(bookName + ": " + millionsSold + ",000,000");
	} // endDisplay
	
	public String toString() {
		return bookName;
	} // end toString
	
	public static void main(String[] args) {
		LinkList theLinkedList = new LinkList();
		
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of The Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter and the Sorcerer's Stone", 107);
		
		//theLinkedList.display();
		
		theLinkedList.removeFirst();
		
		//theLinkedList.display();
		
		System.out.println(theLinkedList.find("The Lord of The Rings").bookName + " was found");
		
		theLinkedList.removeLink("The Lord of The Rings");
		
		theLinkedList.display();
	}

} // end class Link

class LinkList{
	public Link firstLink;
	
	LinkList(){
		firstLink = null; // not necessary
	}
	
	public boolean isEmpty() {
		return(firstLink == null);
	} // end isEmpty
	
	public void insertFirstLink(String bookName, int millionsSold) {
		Link newLink = new Link(bookName, millionsSold);
		
		newLink.next = firstLink;
		
		firstLink = newLink;
	} // end insertFirstLink
	
	public Link removeFirst() {
		Link linkReference = firstLink;
		
		if(!isEmpty()) {
			firstLink = firstLink.next;
		}
		else {
			System.out.println("Empty LinkedList");
		}
		
		return linkReference;
	} // end removeFirst
	
	public void display() {
		Link theLink = firstLink;
		
		while(theLink !=null) {
			theLink.display();
			
			System.out.println("Next Link: " + theLink.next);
			
			theLink = theLink.next;
			
			System.out.println();
		}
	} // end display
	
	public Link find(String bookName) {
		Link theLink = firstLink;
		
		if(!isEmpty()) {
			while(theLink.bookName != bookName) {
				if(theLink.next == null) {
					return null;
				}
				else {
					theLink = theLink.next;
				}
			}
		}
		else {
			System.out.println("empty LinkedList");
		}
		
		return theLink;
	} // end find
	
	public Link removeLink (String bookName) {
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		while(currentLink.bookName != bookName) {
			if(currentLink.next == null) {
				return null;
			}
			else {
				previousLink = currentLink;
				
				currentLink = currentLink.next;
			}
		}
		
		if(currentLink == firstLink) {
			firstLink = firstLink.next;
		}
		else {
			previousLink.next = currentLink.next;
		}
		
		return currentLink;
	}
} // end class LinkList
