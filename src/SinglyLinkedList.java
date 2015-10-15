import java.util.HashSet;
import java.util.List;

public class SinglyLinkedList {
	public Node head;
	int size;
	
	public SinglyLinkedList(){}
	public SinglyLinkedList(Node head) {
		this.head = head;
	}

	public SinglyLinkedList(List<?> list) {
		if (list != null && list.size() > 0) {
			size = 1;
			head = new Node(list.get(0));
			Node temp = head;
			for (int i = 1; i < list.size(); i++) {
				temp.setNext(new Node(list.get(i)));
				temp = temp.getNext();
				size++;
			}
			temp.setNext(null);
		}
	}

	public void add(Node n) {
		if (head == null) {
			head = n;
		} else {
			Node temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
		size++;
	}

	public void removeDuplicates() {
		HashSet<Node> cache = new HashSet<Node>();
		Node temp = head;
		if (temp == null | temp.getNext() == null)
			return;
		cache.add(head);
		while (temp.getNext() != null) {
			if (!cache.contains(temp.getNext())) {
				cache.add(temp.getNext());
				temp = temp.getNext();
			} else {
				temp.setNext(temp.getNext().getNext());
			}
		}
	}

	public void removeDuplicatesWithoutAdditionalBuffer() {
		if (head == null | head.getNext() == null)
			return;
		Node current = head.getNext();
		Node prev = head;
		int index = 1;
		while (current != null) {
			Node running = head;
			int i = 0;
			for (; i < index; i++) {
				if (current.equals(running))
					break;
				running = running.getNext();
			}
			if (i == index) {
				prev = prev.getNext();
				current = current.getNext();
				index++;
			} else{
				prev.setNext(current.getNext());
				current = prev.getNext();
			}
		}
	}
	
	public Node getNode(int i){
		Node temp = head;
		int index = 1;
		while(index <= i && temp != null){
			temp = temp.getNext();
			index++;
		}
		if(temp == null)
			return null;
		return temp;
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.printf("%s   ", temp);
			temp = temp.getNext();
		}
		System.out.println();
	}
}
