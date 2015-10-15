import java.util.Arrays;
import java.util.List;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1’s digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5) + (5 -> 9 ->
 * 2) Output: 8 -> 0 -> 8
 * 
 * @author yue
 *
 */
public class CC2_4 {
	public static void main(String[] args) throws Exception {
		Integer[] a1 = { 1, 6, 8, 3 };
		List<Integer> alist1 = Arrays.asList(a1);
		SinglyLinkedList linkedlist1 = new SinglyLinkedList(alist1);

		Integer[] a2 = { 9, 8, 9, 9 };
		List<Integer> alist2 = Arrays.asList(a2);
		SinglyLinkedList linkedlist2 = new SinglyLinkedList(alist2);
		add(linkedlist1, linkedlist2).print();
		SinglyLinkedList result = new SinglyLinkedList();
		addRecursive(0,linkedlist1.head, linkedlist2.head, result);
		result.print();
		
		Integer[] a3 = {0};
		List<Integer> alist3 = Arrays.asList(a3);
		SinglyLinkedList linkedlist3 = new SinglyLinkedList(alist3);
		add(linkedlist1, linkedlist3).print();
		result = new SinglyLinkedList();
		addRecursive(0,linkedlist1.head, linkedlist3.head, result);
		result.print();
		
	}

	public static SinglyLinkedList add(SinglyLinkedList l1, SinglyLinkedList l2) throws Exception {
		if (l1 == null || l1.head == null || l2 == null || l2.head == null)
			throw new Exception();
		Node nodeFromList1 = l1.head;
		Node nodeFromList2 = l2.head;
		Integer sum;
		Boolean carry = false;
		SinglyLinkedList result = new SinglyLinkedList();
		while (nodeFromList1 != null && nodeFromList2 != null) {
			sum = ((Integer) nodeFromList1.getValue()).intValue() + ((Integer) nodeFromList2.getValue()).intValue();
			if (carry) {
				sum += 1;
				carry = false;
			}
			if (sum / 10 >= 1)
				carry = true;
			sum = sum % 10;
			result.add(new Node(sum));
			nodeFromList1 = nodeFromList1.getNext();
			nodeFromList2 = nodeFromList2.getNext();
		}
		Node reminder = (nodeFromList1 != null) ? nodeFromList1 : nodeFromList2;
		while (reminder != null) {
			sum = ((Integer) reminder.getValue()).intValue();
			if (carry) {
				sum += 1;
				carry = false;
			}
			if (sum / 10 > 1)
				carry = true;
			sum = sum % 10;
			result.add(new Node(sum));
			reminder = reminder.getNext();
		}
		if (carry)
			result.add(new Node(1));
		return result;
	}
	public static void addRecursive(int carry, Node n1, Node n2, SinglyLinkedList result){
		if(n1 ==null && n2 == null)
		{
			if(carry>0)
				result.add(new Node(carry));
			return;
		}
		int sum = carry;
		if(n1 != null)
			sum += ((Integer)n1.getValue()).intValue(); 
		if(n2 != null)
			sum += ((Integer)n2.getValue()).intValue(); 
		carry = sum/10;
		sum = sum % 10;
		result.add(new Node(sum));
		addRecursive(carry, (n1==null)?n1:n1.getNext(), (n2==null)?n2:n2.getNext(), result);
		
	}
}
