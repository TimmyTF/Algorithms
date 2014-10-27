package ru.timmy.adt.stacks.classic;

import ru.timmy.common.StdIn;
import ru.timmy.common.StdOut;

/**
 * Created by tflomin on 30.09.2014.
 *
 */
public class Evaluation {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String s = "";
        while (!StdIn.isEmpty()) { // Read token, push if operator.
            s = StdIn.readString();
            if (s.equals("("))
                StdOut.println("Start");
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } else if ("]".equals(s)) {
                break;
            } /* Token not operator or paren: push double value.*/ else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
