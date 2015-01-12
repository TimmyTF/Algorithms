package ru.timmy.adt.exercises.stack;

import ru.timmy.adt.stacks.vialist.Stack;
import ru.timmy.common.In;
import ru.timmy.common.StdOut;

/**
 * Created by tflomin on 12.01.2015.
 * Reads in a text file and checks to see if the parentheses are balanced.
 *
 *  %  java Parentheses
 *  [()]{}{[()()]()}
 *  true
 *
 *  % java Parentheses
 *  [(])
 *  false
 */
public class ParenthesesBySedgewick {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)
                stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE)
                stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET)
                stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_PAREN)
                    return false;
            }

            else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACE)
                    return false;
            }

            else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACKET)
                    return false;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        In in = new In();
//        String s = "[(])";
        String s = "[()]{}{[()()]()}";
//        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
