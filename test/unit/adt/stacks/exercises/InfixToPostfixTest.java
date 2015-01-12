package unit.adt.stacks.exercises;

import org.junit.Test;
import ru.timmy.adt.exercises.stack.InfixToPostfix;

import java.util.regex.Matcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tflomin on 12.01.2015.
 *
 */
public class InfixToPostfixTest {
    @Test
    public void testNumberPattern() {
        Matcher m = InfixToPostfix.NUMBER.matcher("" + '1');
        assertTrue(m.matches());

        m = InfixToPostfix.NUMBER.matcher("12");
        assertFalse(m.matches());
    }

    @Test
    public void testOperationPattern() {
        Matcher m = InfixToPostfix.OPERATION.matcher("" + '*');
        assertTrue(m.matches());

        m = InfixToPostfix.OPERATION.matcher("" + '+');
        assertTrue(m.matches());
    }

    @Test
    public void testExpressionConversion() {
        assertEquals("1 2 +", InfixToPostfix.convert("1+2"));
        assertEquals("1 2 3 * + 4 -", InfixToPostfix.convert("1+2*3-4"));
    }
}
