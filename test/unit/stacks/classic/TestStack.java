package unit.stacks.classic;

import org.junit.Test;
import ru.timmy.adt.stacks.fixedcapacity.FixedCapacityStackOfStrings;

import static org.junit.Assert.*;

/**
 * Created by tflomin on 13.10.2014.
 *
 */
public class TestStack {
    @Test
    public void testFixedCapacityStackOfStrings() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(6);
        stack.push("q");
        stack.push("w");
        stack.push("e");
        stack.push("r");
        stack.push("t");
        stack.push("y");

        assertTrue(stack.isFull());
    }
}
