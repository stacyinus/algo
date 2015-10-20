import java.util.ArrayList;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when the
 * previous stack exceeds some threshold. Implement a data structure SetOfStacks
 * that mimics this. SetOf- Stacks should be composed of several stacks, and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
 * single stack (that is, pop() should return the same values as it would if
 * there were just a single stack). FOLLOW UP Implement a function popAt(int
 * index) which performs a pop operation on a specific sub-stack.
 **/
public class CC_3_3 {
	public static void main(String[] args){
		int capacity = 5;
		int numOfNodes = 25;
		SetOfStacks stack = new SetOfStacks(capacity);
		for(int i = numOfNodes;i>0;i--){
			stack.push(new NewNode(i));
		}
		for(int j = 0;j<=stack.index;j++)
			stack.printStack(j);
		
		stack.printAll();
//		for(int i = 0;i<numOfNodes;i++){
//			System.out.println("Peeking stack "+ stack.index +" :" + stack.peek().value);
//			System.out.println("Poping stack "+ stack.index +" :" + stack.pop().value);
//		}
		for(int j =0;j<numOfNodes/capacity;j++){
			System.out.println("Poping stack "+ j +" :" + stack.pop(j).value);
			stack.printAll();
		}
	}

	static class SetOfStacks {
		ArrayList<Stack> stacks;
		int capacity; // Capacity of each individual stack inSetOfStacks instance
		int index;// index of the current stack

		public SetOfStacks(int capacity) {
			stacks = new ArrayList<Stack>();
			stacks.add(new Stack(capacity));
			this.capacity = capacity;
			index = 0;
		}

		public void push(NewNode n) {
			Stack current = stacks.get(index);
			if (current.isFull()) {
				System.out.println("Current stack is full, adding one more.....");
				current = new Stack(capacity);
				index++;
				stacks.add(current);
				System.out.println("Current index is " + index);
			}
			current.push(n);
		}

		public NewNode pop() {
			Stack current = stacks.get(index);
			NewNode result = null;
			if (current.isEmpty()) {
				if (index == 0)
					return result;
				stacks.remove(index);
				current = stacks.get(index - 1);
				index--;
			}
			result = current.pop();
			return result;
		}

		public NewNode peek() {
			Stack current = stacks.get(index);
			NewNode result = null;
			if (current.isEmpty()) {
				if (index == 0)
					return result;
				stacks.remove(index);
				current = stacks.get(index - 1);
				index--;
			}
			result = current.peek();
			return result;
		}

		public NewNode pop(int i) {
			NewNode result = null;
			if (i < 0 && i > index)
				return result;
			Stack toPop = stacks.get(i);
			result = toPop.pop();
			while (i < index) {
				stacks.get(i).push(stacks.get(i + 1).removeBottom());
				i++;
			}
			return result;
		}
		public void printStack(int i){
			if(i<=index){
				System.out.printf("Stack %s is :",i);	
				stacks.get(i).printStack();;
			}
		}
		public void printAll(){
			int i = index;
			System.out.println("Printing the entire stack:");
			while(i>=0){
				stacks.get(i).printStack();
				i--;
			}
		}

		public static class Stack {
			NewNode bottom;
			NewNode top;
			int capacity;
			int size;

			public Stack(int capacity) {
				this.capacity = capacity;
			}

			public void push(NewNode n) {
				if (size == capacity)
					System.out.println("This Stack meets its capacity!");
				if (size == 0) {
					bottom = n;
					top = n;
				} else {
					top.prev = n;
					n.next = top;
					top = n;
				}
				size++;
			}

			public NewNode pop() {

				if (size == 0) {
					System.out.println("The Stack is empty!");
					return null;
				}
				NewNode result = top;
				if (size == 1) {
					top = null;
					bottom = null;
				} else {
					top.next.prev = null;
					top = top.next;
				}
				size--;
				return result;
			}

			public NewNode peek() {
				return top;
			}

			public int size() {
				return size;
			}

			public boolean isFull() {
				return size == capacity;
			}

			public boolean isEmpty() {
				if (size == 0)
					return true;
				return false;
			}

			public NewNode removeBottom() {
				if (size == 0) {
					System.out.println("The Stack is empty!");
					return null;
				}
				NewNode result = bottom;
				if (size == 1) {
					top = null;
					bottom = null;
				} else {
					bottom.prev.next = null;
					bottom = bottom.prev;
				}
				size--;
				return result;
			}

			public void printStack() {
				NewNode temp = top;
				while (temp != null){
					System.out.print(temp.value + "  ");
					temp = temp.next;
				}
				System.out.println();
			}
		}

	}
	private static class NewNode {
		NewNode prev;
		NewNode next;
		int value;

		public NewNode(int value) {
			this.value = value;
		}

	}
}
