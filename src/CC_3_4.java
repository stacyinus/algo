
/**
 *  In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different
 *  sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending
 *  order of size from top to bottom (e.g., each disk sits on top of an even larger one). You
 *  have the following constraints:
 *  (A) Only one disk can be moved at a time.
 *  (B) A disk is slid off the top of one rod onto the next rod.
 *  (C) A disk can only be placed on top of a larger disk.
 *  Write a program to move the disks from the first rod to the last using Stacks.	
 */
import java.util.Stack;

public class CC_3_4 {
	public static void main(String[] args) {
		int n = 5;
		Tower[] towers = new Tower[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i+1);
		}
		for (int i = n; i > 0; i--) {
			towers[0].add(i);
		}
		for (int i = 0; i < 3; i++) {
			towers[i].print();
		}
		towers[0].move(5, towers[1], towers[2]);
		for (int i = 0; i < 3; i++) {
			towers[i].print();
		}
	}

	public static class Tower {
		private Stack<Integer> stack;
		int index;
		public Tower(int i) {
			stack = new Stack<Integer>();
			index = i;
		}

		public void add(int i) {
			if (stack.isEmpty() || stack.peek() > i)
				stack.push(i);
			else
				System.out.println("Error!");
		}

		public void move(int i, Tower buffer, Tower destination) {
			if (i <= 0)
				return;
			move(i - 1, destination, buffer);
			int toMove = stack.pop();
			destination.add(toMove);
			buffer.move(i - 1, this, destination);
		}

		public void print() {
			System.out.println("Contents of Tower " + index + " :");
			for (int i = stack.size() - 1; i >= 0; i--)
				System.out.print("  " + stack.get(i));
			System.out.println();
		}
	}
}
