package ru.timmy.adt.exercises.stack;

import ru.timmy.adt.stacks.vialist.Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tflomin on 12.01.2015.
 *
 */
public class InfixToPostfix {
    public static final Pattern NUMBER = Pattern.compile("[0-9]");
    public static final Pattern OPERATION = Pattern.compile("[-+*/]");
    public static final Pattern PARENTHESES = Pattern.compile("[()]");

    public static String convert(String infix) {
        String postfix = "";
        Stack<String> stack = new Stack<String>();

        String number = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isOperation(c)) {
                stack.push("" + c);
                stack.push(number);
                number = "";
            } else if (isNumber(c)) {
                number += c;
            } /*else if (isParentheses(c)) {

            }*/ else {
                throw new IllegalArgumentException();
            }
        }
        stack.push(number);

        for (String s : stack)
            postfix += s + " ";

        if (!"".equals(postfix))
            postfix = postfix.substring(0, postfix.length() - 1);

        return postfix;
    }

    private static boolean isNumber(char c) {
        Matcher m = NUMBER.matcher("" + c);
        return m.matches();
    }

    private static boolean isOperation(char c) {
        Matcher m = OPERATION.matcher("" + c);
        return m.matches();
    }

    private static boolean isParentheses(char c) {
        Matcher m = PARENTHESES.matcher("" + c);
        return m.matches();
    }
}
