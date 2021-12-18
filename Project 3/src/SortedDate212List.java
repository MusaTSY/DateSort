
public class SortedDate212List extends Date212List{
/** default constructor*/
public SortedDate212List() {
	super();//calls the parent constructor with no arguments.
}
public void add(Date212 date) {
	Date212Node node = new Date212Node(date);
	super.Sorted(node);//calls the parent constructor with Date212Node arguments.
}
public String toString() {
	return super.toString();
}
}
