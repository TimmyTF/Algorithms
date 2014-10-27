package ru.timmy.adt.stacks.vialist;

import java.util.Arrays;

/**
 * Created by tflomin on 27.10.2014.
 *
 */
public class OpeningParentheses {
    public Stack<String> parenthesesStack = new Stack<String>();
    public Stack<String> resultStack = new Stack<String>();

    public static void main(String[] args) {
        String stringToProcess = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
//        String stringToProcess = "1 + 3 * 4 - 5) / 6 + 7) - 9)";
        OpeningParentheses openingParentheses = new OpeningParentheses();
        System.out.println(openingParentheses.processParenthesesString(stringToProcess));
    }

    public String processParenthesesString(String stringToProcess) {
        String result = "";
        int outerParenthesesCount = 0;

        for (int i = stringToProcess.length() - 1; i >= 0; i--) {
            if (")".equals("" + stringToProcess.charAt(i)))
                outerParenthesesCount++;

            if (Arrays.asList("*", "/").contains("" + stringToProcess.charAt(i))) {
                parenthesesStack.push("(");
                parenthesesStack.push("" + stringToProcess.charAt(i));
                outerParenthesesCount--;
            } else if (stringToProcess.charAt(i) != ' ') {
                parenthesesStack.push("" + stringToProcess.charAt(i));
            }
        }

        for (String s : parenthesesStack) {
            result += s;
        }

        for (int i = 0; i < outerParenthesesCount; i++)
            result = "(" + result;

        return result;
    }
}
