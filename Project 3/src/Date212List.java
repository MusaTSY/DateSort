
public abstract class Date212List {//is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
	
private Date212Node first ;
private Date212Node last;
@SuppressWarnings("unused")
private int lenght;
public Date212List() {//Declaration 
	/** First node in linked list - dummy node */
	first =  new Date212Node(null);
	/** Last node in linked list */
	last = first;
	/** counter */
	lenght = 0;

}
/**
 * Appends a Date212 data element to this LinkedList.
 * 
 * @param data
 *            the data element to be appended.
 */
public void append(Date212 other) {//Adds another NODE Date212 to the List 
	Date212Node curr = new Date212Node(other);
	last.next = curr;//Becomes Current last 
	lenght++;//amount in the list no really needed for this code 
	last = curr;//last.next is not last anymore the next node will now become last
	
}
/**
 * @return String representation of elements in linked list delimited by a
 *         enter "\n" character
 */
public String toString() {
	String CtoString = "";
	Date212Node curr = first.next;//first.next Because the very first node is null
	while(curr != null) {
		CtoString = CtoString +curr.toString()+"\n";//Calls the toString method in my Date212Node which calls Date212 toString 
		curr = curr.next;//checks the next node
	}
	return CtoString;//returns all the Nodes in a String to be printed to the Text Area
}
/**
 * Appends a Date212 data element that is now sorted to this LinkedList.
 * 
 * @param data
 *            the data element to be appended.
 */
public void Sorted(Date212Node other) {
	Date212Node Sort = first; 
	while(Sort.next !=null&&Sort.next.data.compareTo(other.data)<0) {//Checks if First.next is not Null and calls next from the Date212Node then Date212 CompareTo method
		Sort = Sort.next;//this will keep going to each node until it's null 
	}
	other.next=Sort.next; //Sorts Date Like an else if CompareTo is > 0 
	lenght++;
	Sort.next=other;
	
}

}
