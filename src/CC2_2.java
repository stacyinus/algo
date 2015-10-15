import java.util.Arrays;
import java.util.List;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list.
 * @author yue
 *
 */
public class CC2_2 {
	public static void main(String[] args){
		String[] a1 = {"a","b","c","a","g","c","a"};
		List<String> alist = Arrays.asList(a1);
		SinglyLinkedList linkedlist = new SinglyLinkedList(alist);
		linkedlist.print();
		System.out.println(findNthToTheLastNode(linkedlist,0));
		System.out.println(findNthToTheLastNode(linkedlist,1));
		System.out.println(findNthToTheLastNode(linkedlist,2));
		System.out.println(findNthToTheLastNode(linkedlist,3));
		System.out.println(findNthToTheLastNode(linkedlist,4));
		System.out.println(findNthToTheLastNode(linkedlist,5));
		System.out.println(findNthToTheLastNode(linkedlist,6));
		System.out.println(findNthToTheLastNode(linkedlist,7));
		System.out.println(findNthToTheLastNode(linkedlist,8));
		System.out.println(findNthToTheLastNode(linkedlist,9));
	}
	public static Node findNthToTheLastNode(SinglyLinkedList linkedList, int n ){
		Node n1 = linkedList.head;
		Node n2 = linkedList.head;
		int index = 0;

		while(index < n && n2!=null ){
			n2 = n2.getNext();
			index++;
		}
		if(n2==null){
			System.out.printf("The list has only %s elements so there's no \n", n );
			return null;
		}
		while(n2.getNext()!=null){
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		return n1;
	}
}
