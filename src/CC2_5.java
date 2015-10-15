/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the beginning of the loop. DEFINITION:Circular linked list: A (corrupt)
 * linked list in which a node’s next pointer points to an earlier node, so as
 * to make a loop in the linked list. EXAMPLE input: A -> B -> C -> D -> E -> C
 * [the same C as earlier] output: C
 * 
 * @author yue
 *
 */

public class CC2_5 {
	public static void main(String[] args){
		SinglyLinkedList list = new SinglyLinkedList();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		//change the tail of the list to point to different nodes in the list.
		node6.setNext(node2);
		list.head = node1;
		Node result = returnHeadOfLoop(list);
		System.out.println("Head of the loop is " + result.getValue());
	}
	public static Node returnHeadOfLoop(SinglyLinkedList list) {
		Node pointerSlow = list.head;
		Node pointerFast = list.head;
		while (pointerFast.getNext() != null )  {
			pointerSlow = pointerSlow.getNext();
			pointerFast = pointerFast.getNext().getNext();
			if( pointerSlow == pointerFast)
				break;
		}
		if (pointerFast.getNext() == null)
			return null;
		pointerSlow = list.head;
		while (pointerSlow != pointerFast) {
			pointerSlow = pointerSlow.getNext();
			pointerFast = pointerFast.getNext();
		}
		return pointerFast;
	}
}
