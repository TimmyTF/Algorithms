package unit.adt.stacks.vialist;

import org.junit.ComparisonFailure;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.timmy.adt.stacks.vialist.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by tflomin on 13.10.2014.
 *
 */
public class TestStack {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testStackPush() {
        Stack<String> stack = new Stack<String>();
        stack.push("qwerty");
        stack.push("asdf");
        stack.push("foo");
        stack.push("bar");
        assertEquals(4, stack.size());

        assertEquals("bar", stack.pop());
        assertEquals("foo", stack.pop());
        assertEquals("asdf", stack.pop());
        assertEquals("qwerty", stack.pop());
    }

    @Test
    public void testStackPushException() {
        exception.expect(ComparisonFailure.class);

        Stack<String> stack = new Stack<String>();
        stack.push("qwerty");
        stack.push("asdf");
        stack.push("foo");
        stack.push("bar");
        assertEquals(4, stack.size());

        assertEquals("bazzz", stack.pop());
    }

    @Test
    public void testArrayOfStacks() {
        Stack<String>[] arrayOfStacks = (Stack<String>[]) new Stack[2];
        Stack<String> stack1 = new Stack<String>();
        Stack<String> stack2 = new Stack<String>();
        stack1.push("qwerty");
        stack2.push("asdf");
        arrayOfStacks[0] = stack1;
        arrayOfStacks[1] = stack2;

        assertEquals("qwerty", arrayOfStacks[0].pop());
        assertEquals("asdf", arrayOfStacks[1].pop());
    }

    @Test
    public void testStackPeek() {
        Stack<String> stack = new Stack<String>();
        stack.push("qwerty");
        stack.push("asdf");
        stack.push("foo");
        stack.push("bar");
        assertEquals(4, stack.size());

        assertEquals("bar", stack.peek());
        assertEquals("bar", stack.pop());
        assertEquals("foo", stack.pop());
    }
}
