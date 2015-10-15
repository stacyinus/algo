import java.util.Arrays;
import java.util.List;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 * EXAMPLE
 * Input: the node ‘c’ from the linked list a->b->c->d->e	
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 * @author yue
 *
 */
public class CC2_3 {
	public static void main(String[] args){
		String[] a1 = {"a","b","c","a","g","c","a"};
		List<String> alist = Arrays.asList(a1);
		SinglyLinkedList linkedlist = new SinglyLinkedList(alist);
		linkedlist.print();
		for(int i = 0;i<a1.length-1;i++){
			removeNode(linkedlist.getNode(0));
			linkedlist.print();			
		}
		
	}
	public static void removeNode(Node n){
		Node current = n;
		Node  next = n.getNext();
		while(next.getNext()!=null){
			current.setValue(next.getValue());
			current = next;
			next = next.getNext();
		}
		current.setValue(next.getValue());
		current.setNext(null);
	}
}
