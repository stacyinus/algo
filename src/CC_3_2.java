
/**How would you design a stack which, in addition to push and pop, also has a function
min which returns the minimum element? Push, pop and min should all operate in
O(1) time.
**/
import java.util.Stack;

public class CC_3_2 {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		stack.push(2);
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		stack.push(7);
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		stack.push(1);
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		stack.push(-1);
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		System.out.println("Now popping...................");
		System.out.println("Pop " + stack.pop());
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		System.out.println("Pop " + stack.pop());
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		System.out.println("Pop " + stack.pop());
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		System.out.println("Pop " + stack.pop());
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());

		System.out.println("Pop " + stack.pop());
		System.out.println("Peek " + stack.peek());
		System.out.println("Min " + stack.getMin());
	}

	@SuppressWarnings("serial")
	public static class StackWithMin extends Stack<Integer> {
		Stack<Integer> stackOfMin;

		public StackWithMin() {
			stackOfMin = new Stack<Integer>();
		}

		public Integer push(Integer value) {
			if (value < getMin())
				stackOfMin.push(value);
			return (super.push(value));
		}

		public Integer peek() {
			return (super.peek());
		}

		public Integer pop() {
			Integer value = super.pop();
			if (value == getMin())
				stackOfMin.pop();
			return value;
		}

		public Integer getMin() {
			if (stackOfMin.isEmpty())
				return Integer.MAX_VALUE;
			return (stackOfMin.peek());
		}
	}

}