import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order. You should not make any assumptions
about how the stack is implemented. The following are the only functions that
should be used to write this program: push | pop | peek | isEmpty.
 * @author yue
 *
 */
public class CC_3_5 {
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		int n = 2;
		for(int i = 0; i < n; i++)
			stack.push(i);
		for(int i = stack.size()-1; i>=0;i--){
			System.out.println(stack.get(i));
		}
		System.out.println("The first element is: "+ stack.peek());
		stack = sortStackAsc(stack);
		System.out.println("After sorting....");
		System.out.println("The first element is: "+ stack.peek());
		for(int i = stack.size()-1; i>=0;i--){
			System.out.println(stack.get(i));
		}
	}
	
	public static Stack<Integer> sortStackAsc(Stack<Integer> s){
		Stack<Integer> buffer = new Stack<Integer>();
		while(!s.isEmpty()){
			Integer current = s.pop();
			while(!buffer.isEmpty()&&buffer.peek()<current)
				s.push(buffer.pop());
			buffer.push(current);		
		}
			return buffer;
	}
}
