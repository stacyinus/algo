
public class Node {
	public Object value = null;
	public Node next = null;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public Node(Object o) {
		value = o;
	}

	public Node(Object o, Node n) {
		value = o;
		next = n;
	}

	public void setNext(Node n) {
		next = n;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if( obj.getClass()== Node.class ) {
			Node casted = (Node)obj;
			return value.equals(casted.getValue());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	
	
}
