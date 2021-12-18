
public class Date212Node {
	/**methods/properties can be inherited by child classes.*/
	protected Date212 data;
	protected Date212Node next;
public Date212Node(Date212 d) {//Declaration
	data = d;
	next = null;
}
public String toString() {//calls the toString in Date212
	return data.toString();
}

}
