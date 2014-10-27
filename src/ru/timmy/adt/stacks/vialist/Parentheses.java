package ru.timmy.adt.stacks.vialist;

import ru.timmy.common.StdIn;

import java.util.Arrays;

/**
 * Created by tflomin on 16.10.2014.
 *
 */
public class Parentheses {
    public Stack<String> parenthesesStack = new Stack<String>();

    public boolean checkParentheses(String s) throws IllegalArgumentException {
        if (Arrays.asList("(", "{", "[").contains(s)) {
            parenthesesStack.push(s);
            return true;
        } else if (Arrays.asList(")", "}", "]").contains(s)) {
            return (")".equals(s) && "(".equals(parenthesesStack.pop())) ||
                    ("}".equals(s) && "{".equals(parenthesesStack.pop())) ||
                    ("]".equals(s) && "[".equals(parenthesesStack.pop()));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        boolean result = false;
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if ("S".equals(item) || !(result = parentheses.checkParentheses(item))) {
                break;
            }
        }
        System.out.println("Result: " + result);
    }
}
