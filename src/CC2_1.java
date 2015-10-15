import java.util.Arrays;
import java.util.List;

/**
 * Write code to remove duplicates from an unsorted linked list. How would you
 * solve this problem if a temporary buffer is not allowed?
 * 
 * @author yue
 *
 */
public class CC2_1 {
	//This is test. please see implementation in Class SinglyLinkedList
	public static void main(String[] args) {
		String[] a1 = {"a","b","c","a","g","c","a"};
		List<String> alist = Arrays.asList(a1);
		SinglyLinkedList linkedlist = new SinglyLinkedList(alist);
		linkedlist.print();
		//linkedlist.removeDuplicates();
		linkedlist.removeDuplicatesWithoutAdditionalBuffer();
		linkedlist.print();
		
		
		linkedlist = new SinglyLinkedList(Arrays.asList(new String[] {"a","a","a"}));
		linkedlist.print();
		//linkedlist.removeDuplicates();
		linkedlist.removeDuplicatesWithoutAdditionalBuffer();
		linkedlist.print();
		
		linkedlist = new SinglyLinkedList(Arrays.asList(new String[]{"a"}));
		linkedlist.print();
		//linkedlist.removeDuplicates();
		linkedlist.removeDuplicatesWithoutAdditionalBuffer();
		linkedlist.print();
	}
	
}
