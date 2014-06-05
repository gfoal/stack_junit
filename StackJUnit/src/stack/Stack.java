package stack;

import java.util.EmptyStackException;

public class Stack {
	/**
	 * Changes:
	 * - works with all Objects (from Integer)
	 * - now you can't create Stack instance without stackSize parameter
	 * - 'size' variable renamed to 'position'
	 * - pop() method now deletes last element and doesn't return anything
	 * - peek() method now returns correct element (returned null)
	 */

	private Object[] stack;
	private int position;
	private final int stackSize;

	public Stack(int stackSize){
		if (stackSize > 0) {
			stack = new Object[stackSize];
			position = 0;
			this.stackSize = stackSize;
		} else {
			throw new NegativeArraySizeException();
		}
	}

	public void push(Object item) {
		if (position < stackSize) {
			stack[position] = item;
			position++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void pop() {
		if (!isEmpty()) {
			stack[position] = null;
			position--;
		} else {
			throw new EmptyStackException();
		}
	}

	public Object peek() {
		if (!isEmpty()) {
			return stack[position - 1];
		} else {
			throw new EmptyStackException();
		}
	}

	public boolean isEmpty() {
		return position == 0;
	}
}
