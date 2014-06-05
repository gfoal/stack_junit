package stack;

import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.*;

public class Test_Stack {
	/** 
	 * These are Unit tests for Stack
	 * Since all fields are private peek() acts as getter for the last element
	 */

	private Stack testStack;

	@After
	public void clear() {
		testStack = null;
	}

	// POSITIVE TESTS
	@Test
	public void push_pushOneElement_elementAddedToEndOfStack() {
		//Testing push() method
		int stackSize = 10;
		String checker = "10";
		testStack = new Stack(stackSize);

		testStack.push(checker);
		assertEquals(checker, testStack.peek());
	}

	@Test
	public void pop_pushTwoElements_lastElementDeleted() {
		// Testing pop() method
		int stackSize = 3;
		Integer checker = 10;
		testStack = new Stack(stackSize);

		testStack.push(checker);
		testStack.push(5);
		testStack.pop();
		assertEquals(checker, testStack.peek());
	}

	@Test
	public void peek_pushOneElement_lastElementReturned() {
		// Testing peek() method
		int stackSize = 10;
		int checker = 10;
		testStack = new Stack(stackSize);

		testStack.push(checker);
		assertEquals(checker, testStack.peek());
	}

	@Test
	public void empty_True() {
		// Testing empty() method on an empty stack
		int stackSize = 10;
		testStack = new Stack(stackSize);

		assertTrue(testStack.isEmpty());
	}

	@Test
	public void empty_False() {
		// Testing empty() method on a non-empty stack
		int stackSize = 10;
		testStack = new Stack(stackSize);

		testStack.push("insert object here");
		assertFalse(testStack.isEmpty());
	}

	//NEGATIVE TESTS
	@Test(expected=NegativeArraySizeException.class)
	public void constructor_negativeSize_exceptionIsThrown() {
		// Testing constructor with negative size
		testStack = new Stack(-1);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void push_overflaw_exceptionThrown() {
		// Testing push() on a full stack
		testStack = new Stack(1);

		testStack.push(1);
		testStack.push(4);
	}

	@Test(expected=EmptyStackException.class)
	public void pop_empty_exceptionThrown() {
		// Testing pop() on an empty stack
		testStack = new Stack(1);

		testStack.pop();
	}

	@Test(expected=EmptyStackException.class)
	public void peek_empty_exceptionThrown() {
		// Testing peek() on an empty stack
		testStack = new Stack(1);

		testStack.peek();
	}
}
